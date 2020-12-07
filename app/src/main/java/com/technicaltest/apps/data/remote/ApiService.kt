package com.technicaltest.apps.data.remote

import com.squareup.moshi.JsonAdapter
import com.technicaltest.apps.data.remote.response.News
import retrofit2.http.*
import se.ansman.kotshi.KotshiJsonAdapterFactory

interface ApiService {
    @GET("everything?q={q}&from={from}&sortBy=publishedAt&apiKey={key}")
    suspend fun getListNews(
        @Path("q") q: String?,
        @Path("from") from: String?,
        @Path("key") key: String?
    ): News

}

@KotshiJsonAdapterFactory
object ApplicationJsonAdapterFactory : JsonAdapter.Factory by KotshiApplicationJsonAdapterFactory