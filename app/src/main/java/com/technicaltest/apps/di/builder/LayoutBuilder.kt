package com.technicaltest.apps.di.builder


import com.technicaltest.apps.ui.screen.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@Module
abstract class LayoutBuilder {

    @ExperimentalCoroutinesApi
    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment

}