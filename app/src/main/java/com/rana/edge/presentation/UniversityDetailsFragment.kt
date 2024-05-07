package com.rana.edge.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.rana.edge.data.local.UniversityEntity
import com.rana.edge.databinding.FragDetailsBinding

class UniversityDetailsFragment : Fragment() {

    private var _binding: FragDetailsBinding? = null
    private val binding: FragDetailsBinding get() = _binding!!

    @SuppressLint("NewApi")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragDetailsBinding.inflate(inflater, container, false)

        // Get the UniversityEntity object from the arguments
        val universityEntity = arguments?.getParcelable("data", UniversityEntity::class.java)

        with(binding) {
            // Bind the data to the views
            universityName.text = universityEntity?.name
            universityCountry.text = universityEntity?.country
            universityWebsite.text = universityEntity?.stateProvince

            button.setOnClickListener {
                setFragmentResult("requestKey", bundleOf("shouldRefresh" to true))
                findNavController().navigateUp()
            }
        }

        return binding.root
    }
}