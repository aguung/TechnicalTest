package com.technicaltest.apps.di.module

import com.squareup.moshi.Moshi
import com.technicaltest.apps.BuildConfig
import com.technicaltest.apps.data.remote.ApiService
import com.technicaltest.apps.data.remote.ApplicationJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG){
                    HttpLoggingInterceptor.Level.BODY
                }else{
                    HttpLoggingInterceptor.Level.NONE
                }
            })
            .build()
    }

    @Singleton
    @Provides
    fun providesRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .client(okHttpClient)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(ApplicationJsonAdapterFactory).build()
                )
            )
    }

    @Singleton
    @Provides
    fun provideApiService(builder: Retrofit.Builder): ApiService {
        return builder.baseUrl(BuildConfig.SERVER_URL)
            .build()
            .create(ApiService::class.java)
    }
}