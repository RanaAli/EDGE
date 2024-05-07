package com.rana.edge.data.repository

import com.rana.model.UniversityEntity

sealed class Result {
    data class Success(val data: List<com.rana.model.UniversityEntity>) : Result()
    data object Error : Result()

}