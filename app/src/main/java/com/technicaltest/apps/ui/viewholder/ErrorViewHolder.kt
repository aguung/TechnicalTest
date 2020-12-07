package com.technicaltest.apps.ui.viewholder

import android.view.View
import com.technicaltest.apps.R
import com.technicaltest.apps.data.ErrorType
import com.technicaltest.apps.databinding.ItemErrorBinding
import com.technicaltest.apps.utils.BaseViewHolder
import com.technicaltest.apps.utils.ItemModel
import com.technicaltest.apps.utils.ViewHolderFactory

data class ErrorItemModel(
    val errorType: ErrorType
) : ItemModel {
    override fun layoutId(): Int = R.layout.item_error
}

class ErrorViewHolder(private val binding: ItemErrorBinding) :
    BaseViewHolder<ErrorItemModel>(binding.root) {

    init {
        binding.textTry.addOnItemClick()
    }

    override fun bind(item: ErrorItemModel) {
        when (item.errorType) {
            ErrorType.SOMETHING_WRONG -> {
                binding.textTitle.text = "Something Wrong"
                binding.image.setAnimationFromUrl("https://assets3.lottiefiles.com/temp/lf20_0txt7u.json")
            }
            ErrorType.CONNECTION -> {
                binding.textTitle.text = "Connection Error"
                binding.image.setAnimationFromUrl("https://assets9.lottiefiles.com/temp/lf20_6bhHgV.json")
            }
            ErrorType.UNAUTHORIZED -> {
                binding.textTitle.text = "Unautorhized"
                binding.image.setAnimationFromUrl("https://assets4.lottiefiles.com/packages/lf20_oSMJuN.json")
            }
            ErrorType.NOT_FOUND -> {
                binding.textTitle.text = "Empty Item"
                binding.image.setAnimationFromUrl("https://assets3.lottiefiles.com/temp/lf20_0txt7u.json")
            }
        }
        binding.image.playAnimation()
    }
}

class ErrorViewHolderFactory : ViewHolderFactory {
    override fun layoutId(): Int = R.layout.item_error

    override fun createViewHolder(viewItem: View): BaseViewHolder<*> =
        ErrorViewHolder(ItemErrorBinding.bind(viewItem))

    override fun bindViewHolder(viewHolder: BaseViewHolder<*>, itemModel: ItemModel) {
        (viewHolder as ErrorViewHolder).bind(itemModel as ErrorItemModel)
    }
}