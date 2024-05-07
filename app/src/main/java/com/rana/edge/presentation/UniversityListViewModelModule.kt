package com.rana.edge.presentation

import com.rana.edge.data.remote.repository.UniversityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UniversityListViewModelModule {

    @ViewModelScoped
    @Provides
    fun provideUniversityListViewModel(
        universityRepository: UniversityRepository
    ): ListViewModel {
        return ListViewModel(universityRepository)
    }
}