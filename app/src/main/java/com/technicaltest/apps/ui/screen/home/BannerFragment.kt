package com.technicaltest.apps.ui.screen.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.technicaltest.apps.databinding.FragmentBannerBinding


class BannerFragment : Fragment() {
    private val binding: FragmentBannerBinding by lazy {
        FragmentBannerBinding.inflate(layoutInflater)
    }
    companion object{
        const val IMAGE = "IMAGE"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(IMAGE) }?.apply {
            binding.imgBaner.setImageResource(getInt(IMAGE))
        }
    }
}