package com.rana.edge.data.repository

import com.rana.edge.data.local.UniversityEntity

sealed class Result {
    data class Success(val data: List<UniversityEntity>) : Result()
    data object Error : Result()

}