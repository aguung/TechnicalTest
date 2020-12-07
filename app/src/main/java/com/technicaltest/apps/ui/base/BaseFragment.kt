package com.technicaltest.apps.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.technicaltest.apps.ui.viewholder.EmptyViewHolderFactory
import com.technicaltest.apps.ui.viewholder.ErrorViewHolderFactory
import com.technicaltest.apps.ui.viewholder.ItemNewsViewHolderFactory
import com.technicaltest.apps.ui.viewholder.LoadingViewHolderFactory
import com.technicaltest.apps.utils.RecyclerViewListAdapter
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

@ExperimentalCoroutinesApi
open class BaseFragment : Fragment() {

    protected val adapter: RecyclerViewListAdapter = RecyclerViewListAdapter()
        .registerViewHolderFactory(EmptyViewHolderFactory())
        .registerViewHolderFactory(ErrorViewHolderFactory())
        .registerViewHolderFactory(LoadingViewHolderFactory())
        .registerViewHolderFactory(ItemNewsViewHolderFactory())

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
}