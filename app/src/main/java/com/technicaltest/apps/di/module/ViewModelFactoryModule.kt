package com.technicaltest.apps.di.module

import androidx.lifecycle.ViewModelProvider
import com.technicaltest.apps.ui.screen.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {
    @Binds
    fun bindsViewModelFactory(providerFactory: ViewModelFactory): ViewModelProvider.Factory
}