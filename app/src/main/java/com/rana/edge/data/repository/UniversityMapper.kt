package com.rana.edge.data.repository

import com.rana.model.UniversityEntity
import com.rana.edge.data.remote.response.UniversityResponse
import com.rana.edge.data.remote.response.UniversityResponseItem

fun UniversityResponse.toUniversityEntityList(): List<com.rana.model.UniversityEntity> {
    return map {
        it.toUniversityEntity()
    }
}

fun UniversityResponseItem.toUniversityEntity(): com.rana.model.UniversityEntity {
    return com.rana.model.UniversityEntity(
        universityId = 0,
        name = name ?: "",
        country = country ?: "",
        stateProvince = stateProvince ?: ""
    )
}