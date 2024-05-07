package com.rana.edge.data.repository

import android.util.Log
import com.rana.edge.data.local.UniversityEntity
import com.rana.edge.data.local.datastore.UniversityLocalDatastore
import com.rana.edge.data.remote.api.UniversityApi
import com.rana.edge.data.remote.response.UniversityResponse
import retrofit2.Response

class UniversityRepositoryImpl(
    private val universityApi: UniversityApi,
    private val universityLocalDatastore: UniversityLocalDatastore
) : UniversityRepository {

    override suspend fun getUniversities(): Result {

        try {
            val response: Response<UniversityResponse> = universityApi.getUniversities()

            if (response.isSuccessful) {
                response.body()?.let {
                    Log.e("UniversityRepository", "loaded from remote")
                    val data = it.toUniversityEntityList()
                    universityLocalDatastore.saveUniversities(data)
                    return Result.Success(data)
                }
            }

            // Check if universities are available in the local datastore.
            val localUniversities = universityLocalDatastore.getUniversities()
            if (localUniversities.isNotEmpty()) {
                Log.e("UniversityRepository", "loaded from local")
                return Result.Success(localUniversities)
            }
        } catch (_: Exception) {

        }

        return Result.Error
    }
}