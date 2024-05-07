package com.rana.edge.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rana.edge.data.local.UniversityEntity
import com.rana.edge.data.repository.UniversityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val universityRepository: UniversityRepository
) : ViewModel() {

    private val _universities = MutableLiveData<List<UniversityEntity>>()
    val universities: LiveData<List<UniversityEntity>> = _universities

    fun getUniversities() {
        viewModelScope.launch {
            _universities.value = universityRepository.getUniversities()
        }
    }
}