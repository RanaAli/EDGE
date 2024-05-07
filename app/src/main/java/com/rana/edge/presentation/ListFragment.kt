package com.rana.edge.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rana.edge.data.local.UniversityEntity
import com.rana.edge.databinding.FragListBinding
import com.rana.edge.presentation.ListFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModels()

    private var _binding: FragListBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            viewModel.getUniversities()
        }
    }

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

            // Set up the SwipeRefreshLayout
            swipeRefreshLayout.setOnRefreshListener {
                Log.d("List Fragment", "pull to refresh called")
                viewModel.getUniversities()
            }

            viewModel.universities.observe(viewLifecycleOwner) { universities ->
                recyclerView.adapter = MyAdapter(universities, ::goToDetails)
                swipeRefreshLayout.isRefreshing = false
                loadingIndicator.visibility = View.GONE
            }

            viewModel.error.observe(viewLifecycleOwner) {
                loadingIndicator.visibility = View.GONE
                swipeRefreshLayout.isRefreshing = false
                if (it.isNotBlank()) {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
                    viewModel.errorShown()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun goToDetails(universityEntity: UniversityEntity) {
        findNavController().navigate(
            ListFragmentDirections.actionListFragmentToUniversityDetailsFragment(
                universityEntity
            )
        )
    }
}