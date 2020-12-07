package com.technicaltest.apps.ui.viewholder

import android.view.View
import com.technicaltest.apps.R
import com.technicaltest.apps.data.EmptyType
import com.technicaltest.apps.databinding.ItemEmptyBinding
import com.technicaltest.apps.utils.BaseViewHolder
import com.technicaltest.apps.utils.ItemModel
import com.technicaltest.apps.utils.ViewHolderFactory

data class EmptyItemModel(val emptyType: EmptyType) : ItemModel {
    override fun layoutId(): Int = R.layout.item_empty
}

class EmptyViewHolder(private val binding: ItemEmptyBinding) :
    BaseViewHolder<EmptyItemModel>(binding.root) {

    override fun bind(item: EmptyItemModel) {
        when (item.emptyType) {
            EmptyType.NO_MORE -> {
                binding.textTitle.text = "No More"
            }
        }
        binding.image.playAnimation()
    }
}

class EmptyViewHolderFactory : ViewHolderFactory {
    override fun layoutId(): Int = R.layout.item_empty

    override fun createViewHolder(viewItem: View): BaseViewHolder<*> =
        EmptyViewHolder(ItemEmptyBinding.bind(viewItem))

    override fun bindViewHolder(viewHolder: BaseViewHolder<*>, itemModel: ItemModel) {
        (viewHolder as EmptyViewHolder).bind(itemModel as EmptyItemModel)
    }
}