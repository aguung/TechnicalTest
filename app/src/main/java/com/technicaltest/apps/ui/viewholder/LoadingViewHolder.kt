package com.technicaltest.apps.ui.viewholder

import android.view.View
import com.technicaltest.apps.R
import com.technicaltest.apps.databinding.ItemLoadingBinding
import com.technicaltest.apps.utils.BaseViewHolder
import com.technicaltest.apps.utils.ItemModel
import com.technicaltest.apps.utils.ViewHolderFactory

data class LoadingItemModel(val type: String) : ItemModel {
    override fun layoutId(): Int = R.layout.item_loading
}

class LoadingViewHolder(private val binding: ItemLoadingBinding) :
    BaseViewHolder<LoadingItemModel>(binding.root) {

    override fun bind(item: LoadingItemModel) {

    }
}

class LoadingViewHolderFactory : ViewHolderFactory {
    override fun layoutId(): Int = R.layout.item_loading

    override fun createViewHolder(viewItem: View): BaseViewHolder<*> =
        LoadingViewHolder(ItemLoadingBinding.bind(viewItem))

    override fun bindViewHolder(viewHolder: BaseViewHolder<*>, itemModel: ItemModel) {
        (viewHolder as LoadingViewHolder).bind(itemModel as LoadingItemModel)
    }
}