package com.technicaltest.apps.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.technicaltest.apps.ui.viewholder.EmptyItemModel
import com.technicaltest.apps.data.Resource
import com.technicaltest.apps.ui.viewholder.ErrorItemModel
import com.technicaltest.apps.ui.viewholder.LoadingItemModel
import com.technicaltest.apps.utils.ItemModel
import com.technicaltest.apps.utils.errorMapper
import kotlinx.coroutines.Job

open class BaseViewModel : ViewModel() {
    protected val items = MutableLiveData<Resource<List<ItemModel>>>()
    protected var job: Job? = null

    protected fun showError(throwable: Throwable) {
        throwable.printStackTrace()
        items.postValue(
            Resource.error(
                throwable.message,
                listOf(ErrorItemModel(throwable.errorMapper()))
            )
        )
    }

    protected fun showLoading(isLoadMore: Boolean = false) {
        val loadingItems: List<ItemModel> = if (isLoadMore) {
            val currentItems = items.value?.data?.toMutableList() ?: mutableListOf()
            currentItems.removeAll { it is LoadingItemModel || it is EmptyItemModel || it is ErrorItemModel }
            currentItems.add(LoadingItemModel("Load"))
            currentItems
        } else {
            listOf(LoadingItemModel("Empty"))
        }
        items.postValue(Resource.loading(loadingItems))
    }
}