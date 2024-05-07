package com.rana.edge.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rana.model.UniversityEntity
import com.rana.edge.data.repository.Result
import com.rana.edge.data.repository.UniversityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val universityRepository: UniversityRepository
) : ViewModel() {

    private val _universities = MutableLiveData<List<com.rana.model.UniversityEntity>>()
    val universities: LiveData<List<com.rana.model.UniversityEntity>> = _universities

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        getUniversities()
    }

    fun getUniversities() {
        viewModelScope.launch {

            when (val result = universityRepository.getUniversities()) {
                is Result.Error -> _error.value = "There was an error"
                is Result.Success -> _universities.value = result.data
            }

        }
    }

    fun errorShown(){
        _error.value = ""
    }
}