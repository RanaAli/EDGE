package com.rana.edge.data.remote.repository

import com.rana.edge.data.local.UniversityEntity

interface UniversityRepository {

    suspend fun getUniversities(): List<UniversityEntity>
}