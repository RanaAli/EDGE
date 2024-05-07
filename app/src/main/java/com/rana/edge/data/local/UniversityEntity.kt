package com.rana.edge.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "universities")
data class UniversityEntity(
    @PrimaryKey(autoGenerate = true) val universityId: Int = 0,
    val name: String,
    val country: String,
    val stateProvince: String
)