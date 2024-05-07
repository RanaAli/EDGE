package com.rana.edge.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rana.edge.data.local.dao.UniversityDao
import com.rana.model.UniversityEntity

@Database(
    entities = [UniversityEntity::class],
    version = 1,
    exportSchema = false
)
abstract class UniversityDatabase : RoomDatabase() {

    abstract fun universityDao(): UniversityDao
}