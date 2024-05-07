package com.rana.edge.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rana.edge.databinding.FragListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModels()

    private var _binding: FragListBinding? = null

    private val binding get() = _binding!!

    // This property is only valid between onCreateView and onDestroyView.
//    private val viewModel: ListViewModel by activityViewModels {
//        UniversityListViewModelFactory(
//            (requireActivity().application as UniversityApplication).universityRepository
//        )
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using view binding
        _binding = FragListBinding.inflate(inflater, container, false)

        _binding?.apply {
            // Set up the RecyclerView
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            loadingIndicator.visibility = View.VISIBLE

            viewModel.getUniversities()
            // Set up the SwipeRefreshLayout
            swipeRefreshLayout.setOnRefreshListener {
                Log.d("List Fragment", "pull to refresh called")
                viewModel.getUniversities()
            }


            viewModel.universities.observe(viewLifecycleOwner) { universities ->
                swipeRefreshLayout.isRefreshing = false
                recyclerView.adapter = MyAdapter(universities)
                loadingIndicator.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}