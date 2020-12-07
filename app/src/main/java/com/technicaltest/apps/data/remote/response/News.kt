package com.technicaltest.apps.data.remote.response


import com.squareup.moshi.Json
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class News(
    @Json(name = "articles")
    val articles: List<Article> = listOf(),
    @Json(name = "status")
    val status: String?,
    @Json(name = "totalResults")
    val totalResults: Int?
)