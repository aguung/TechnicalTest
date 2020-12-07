package com.technicaltest.apps.ui.viewholder

import android.view.View
import com.squareup.moshi.Json
import com.technicaltest.apps.R
import com.technicaltest.apps.data.remote.response.Source
import com.technicaltest.apps.databinding.ItemRvNewsBinding
import com.technicaltest.apps.utils.BaseViewHolder
import com.technicaltest.apps.utils.ItemModel
import com.technicaltest.apps.utils.ViewHolderFactory

data class ItemNewsItemModel(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : ItemModel {
    override fun layoutId(): Int = R.layout.item_rv_news
}

class ItemNewsViewHolder(private val binding: ItemRvNewsBinding) :
    BaseViewHolder<ItemNewsItemModel>(binding.root) {

    init {
        binding.constraint.addOnItemClick()
    }

    override fun bind(item: ItemNewsItemModel) {

    }
}

class ItemNewsViewHolderFactory : ViewHolderFactory {
    override fun layoutId(): Int = R.layout.item_rv_news

    override fun createViewHolder(viewItem: View): BaseViewHolder<*> =
        ItemNewsViewHolder(ItemRvNewsBinding.bind(viewItem))

    override fun bindViewHolder(viewHolder: BaseViewHolder<*>, itemModel: ItemModel) {
        (viewHolder as ItemNewsViewHolder).bind(itemModel as ItemNewsItemModel)
    }
}