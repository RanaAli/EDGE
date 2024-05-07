package com.rana.edge.data.remote.api

import com.rana.edge.data.remote.response.UniversityResponse
import retrofit2.Response
import retrofit2.http.GET

interface UniversityApi {

    @GET("search?country=United%20Arab%20Emirates")
    suspend fun getUniversities(): Response<UniversityResponse>
}