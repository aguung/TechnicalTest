package com.technicaltest.apps.di.module

import com.technicaltest.apps.data.Repository
import com.technicaltest.apps.data.RepositoryImpl
import com.technicaltest.apps.data.remote.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesRepository(apiService: ApiService): Repository {
        return RepositoryImpl(apiService)
    }
}