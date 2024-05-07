package com.rana.edge.data.repository

import com.rana.edge.data.local.UniversityEntity
import com.rana.edge.data.remote.response.UniversityResponse
import com.rana.edge.data.remote.response.UniversityResponseItem

fun UniversityResponse.toUniversityEntityList(): List<UniversityEntity> {
    return map {
        it.toUniversityEntity()
    }
}

fun UniversityResponseItem.toUniversityEntity(): UniversityEntity {
    return UniversityEntity(
        universityId = 0,
        name = name ?: "",
        country = country ?: "",
        stateProvince = stateProvince ?: ""
    )
}