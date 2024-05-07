package com.rana.edge.data.remote.datastore

import com.rana.edge.data.remote.api.UniversityApi

class UniversityRemoteDatastore(private val universityApi: UniversityApi) {
    suspend fun getUniversities() = universityApi.getUniversities()
}