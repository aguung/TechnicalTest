package com.technicaltest.apps.di.component

import android.app.Application
import com.technicaltest.apps.TechnicalTest
import com.technicaltest.apps.di.builder.LayoutBuilder
import com.technicaltest.apps.di.module.ApiModule
import com.technicaltest.apps.di.module.RepositoryModule
import com.technicaltest.apps.di.module.ViewModelFactoryModule
import com.technicaltest.apps.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import javax.inject.Singleton

@FlowPreview
@ExperimentalCoroutinesApi
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApiModule::class,
        RepositoryModule::class,
        LayoutBuilder::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class
    ]
)

interface AppComponent : AndroidInjector<TechnicalTest> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(app: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: TechnicalTest?)
}