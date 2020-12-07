package com.technicaltest.apps.data

import com.technicaltest.apps.data.remote.ApiService
import com.technicaltest.apps.data.remote.response.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@ExperimentalCoroutinesApi
class RepositoryImpl @Inject constructor(
    private var apiService: ApiService
) : Repository {
    override suspend fun listNews(api: String?): Flow<() -> News> = flow {
        val tagihan = apiService.getListNews(q = "bitcoin", from = "2020-11-07", key = api)
        emit { tagihan }
    }.flowOn(Dispatchers.IO)


}