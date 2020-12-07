package com.technicaltest.apps.data

import com.technicaltest.apps.data.remote.response.News
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun listNews(
        api: String?
    ): Flow<() -> News>
}