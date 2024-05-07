package com.rana.edge.data.repository

interface UniversityRepository {

    suspend fun getUniversities(): Result
}