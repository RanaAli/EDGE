package com.rana.edge.data.local.datastore

import com.rana.model.UniversityEntity
import com.rana.edge.data.local.db.UniversityDatabase

class UniversityLocalDatastore(
    private val universityDatabase: UniversityDatabase
) {

    suspend fun getUniversities(): List<com.rana.model.UniversityEntity> {
        return universityDatabase.universityDao().getAllUniversities()
    }

    suspend fun saveUniversities(universities: List<com.rana.model.UniversityEntity>) {
        universityDatabase.universityDao().insertUniversities(universities)
    }
}