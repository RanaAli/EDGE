package com.rana.edge.di

import com.rana.edge.data.repository.UniversityRepository
import com.rana.edge.presentation.ListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @ViewModelScoped
    @Provides
    fun provideUniversityListViewModel(
        universityRepository: UniversityRepository
    ): ListViewModel {
        return ListViewModel(universityRepository)
    }
}