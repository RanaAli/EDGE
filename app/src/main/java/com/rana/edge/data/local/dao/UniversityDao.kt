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
    suspend fun insertUniversities(universities: List<UniversityEntity>)

    @Query("SELECT * FROM universities")
    suspend fun getAllUniversities(): List<UniversityEntity>

    @Query("SELECT * FROM universities WHERE universityId = :universityId")
    suspend fun getUniversity(universityId: Int): UniversityEntity?

    @Update
    suspend fun updateUniversity(university: UniversityEntity)

    @Delete
    suspend fun deleteUniversity(university: UniversityEntity)

    @Query("DELETE FROM universities")
    suspend fun deleteAllUniversities()
}