package com.technicaltest.apps.data.remote.response


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Source(
    @Json(name = "id")
    val id: String?,
    @Json(name = "name")
    val name: String?
) : Parcelable