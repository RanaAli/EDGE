package com.rana.edge.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.rana.model.UniversityEntity


@Dao
interface UniversityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUniversities(universities: List<com.rana.model.UniversityEntity>)

    @Query("SELECT * FROM universities")
    suspend fun getAllUniversities(): List<com.rana.model.UniversityEntity>

    @Query("SELECT * FROM universities WHERE universityId = :universityId")
    suspend fun getUniversity(universityId: Int): com.rana.model.UniversityEntity?

    @Update
    suspend fun updateUniversity(university: com.rana.model.UniversityEntity)

    @Delete
    suspend fun deleteUniversity(university: com.rana.model.UniversityEntity)

    @Query("DELETE FROM universities")
    suspend fun deleteAllUniversities()
}