package com.rana.edge.data.local.datastore

import com.rana.edge.data.local.UniversityEntity
import com.rana.edge.data.local.db.UniversityDatabase

class UniversityLocalDatastore(
    private val universityDatabase: UniversityDatabase
) {

    suspend fun getUniversities(): List<UniversityEntity> {
        return universityDatabase.universityDao().getAllUniversities()
    }

    suspend fun saveUniversities(universities: List<UniversityEntity>) {
        universityDatabase.universityDao().insertUniversities(universities)
    }
}