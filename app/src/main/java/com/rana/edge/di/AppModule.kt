package com.rana.edge.di

import android.content.Context
import androidx.room.Room
import com.rana.edge.data.local.datastore.UniversityLocalDatastore
import com.rana.edge.data.local.db.UniversityDatabase
import com.rana.edge.data.remote.api.ApiUrls
import com.rana.edge.data.remote.api.UniversityApi
import com.rana.edge.data.repository.UniversityRepository
import com.rana.edge.data.repository.UniversityRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideUniversityRepository(
        universityApi: UniversityApi,
        universityLocalDatastore: UniversityLocalDatastore
    ): UniversityRepository {
        return UniversityRepositoryImpl(universityApi, universityLocalDatastore)
    }

    @Provides
    @Singleton
    fun provideUniversityApi(): UniversityApi {
        return Retrofit.Builder()
            .baseUrl(ApiUrls.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build())
            .build()
            .create(UniversityApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUniversityLocalDatastore(universityDatabase: UniversityDatabase): UniversityLocalDatastore {
        return UniversityLocalDatastore(universityDatabase)
    }

    @Provides
    @Singleton
    fun provideUniversityDatabase(@ApplicationContext context: Context): UniversityDatabase {
        return Room.databaseBuilder(
            context,
            UniversityDatabase::class.java,
            "university_database"
        ).build()
    }
}