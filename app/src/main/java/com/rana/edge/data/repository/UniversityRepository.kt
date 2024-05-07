package com.rana.edge.data.repository

import com.rana.edge.data.local.UniversityEntity

interface UniversityRepository {

    suspend fun getUniversities(): Result
}