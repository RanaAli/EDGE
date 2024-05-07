package com.rana.edge.presentation

import android.app.Application
import androidx.room.Room
import com.rana.edge.data.local.db.UniversityDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UniversityApplication : Application() {

//    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

//        val universityDatabase: UniversityDatabase = Room.databaseBuilder(
//            applicationContext,
//            UniversityDatabase::class.java,
//            "university_database"
//        )
//            .build()
    }
}