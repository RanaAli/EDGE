package com.rana.edge.data.remote.repository

import android.util.Log
import com.rana.edge.data.local.UniversityEntity
import com.rana.edge.data.local.datastore.UniversityLocalDatastore
import com.rana.edge.data.remote.api.UniversityApi

class UniversityRepositoryImpl(
    private val universityApi: UniversityApi,
    private val universityLocalDatastore: UniversityLocalDatastore
) : UniversityRepository {

    override suspend fun getUniversities(): List<UniversityEntity> {
        // Check if universities are available in the local datastore.
        val localUniversities = universityLocalDatastore.getUniversities()
        if (localUniversities.isNotEmpty()) {
            Log.d("UniversityRepository", "loaded from local")
            return localUniversities
        }

        // Fetch universities from the API.
        val remoteUniversities = universityApi.getUniversities().toUniversityEntityList()
        Log.d("UniversityRepository", "loaded from remote")

        // Save the universities in the local datastore.
        universityLocalDatastore.saveUniversities(remoteUniversities)

        return remoteUniversities
    }
}