package com.rana.edge.data.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "universities")
data class UniversityEntity(
    @PrimaryKey(autoGenerate = true) val universityId: Int = 0,
    val name: String,
    val country: String,
    val stateProvince: String
) : Parcelable