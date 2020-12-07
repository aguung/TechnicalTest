package com.technicaltest.apps.ui.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.technicaltest.apps.data.EmptyType
import com.technicaltest.apps.data.Repository
import com.technicaltest.apps.data.Resource
import com.technicaltest.apps.data.remote.response.News
import com.technicaltest.apps.ui.base.BaseViewModel
import com.technicaltest.apps.ui.viewholder.EmptyItemModel
import com.technicaltest.apps.ui.viewholder.ErrorItemModel
import com.technicaltest.apps.ui.viewholder.ItemNewsItemModel
import com.technicaltest.apps.ui.viewholder.LoadingItemModel
import com.technicaltest.apps.utils.ItemModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
class HomeViewModel @Inject constructor(private val repository: Repository) : BaseViewModel() {
    fun fetchNews(key: String?, isLoadMore: Boolean = false) {
        job?.cancel()
        job = viewModelScope.launch {
            repository.listNews(api = key)
                .map {
                    newsMapToItem(it.invoke())
                }.catch {
                    showError(it)
                }.collect {
                    items.postValue(Resource.success(it))
                }
        }
    }

    private fun newsMapToItem(
        newsResult: News
    ): List<ItemModel> {
        val newItems = newsResult.articles.map {
            ItemNewsItemModel(
                author = it.author,
                content = it.content,
                description = it.description,
                publishedAt = it.publishedAt,
                source = it.source,
                title = it.title,
                url = it.url,
                urlToImage = it.urlToImage
            )
        }

        val oldItems = items.value?.data?.toMutableList() ?: mutableListOf()
        oldItems.removeAll { it is LoadingItemModel || it is EmptyItemModel || it is ErrorItemModel }

        return mutableListOf<ItemModel>().apply {
            addAll(oldItems)
            addAll(newItems)
        }
    }

    fun isNoMoreDataToLoad(items: List<ItemModel>): Boolean =
        items.contains(EmptyItemModel(EmptyType.NO_MORE))

    fun getItems(): LiveData<Resource<List<ItemModel>>> = items

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}