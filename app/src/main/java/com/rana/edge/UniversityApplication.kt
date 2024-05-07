package com.rana.edge

import android.app.Application
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