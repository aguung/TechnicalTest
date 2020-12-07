package com.technicaltest.apps.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.technicaltest.apps.ui.screen.BannerFragment

class ScreenSlidePagerAdapter(
    fragment: Fragment,
    private val content:List<Int>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = content.size

    override fun createFragment(position: Int): Fragment {
        val fragment = BannerFragment()
        fragment.arguments = Bundle().apply {
            putInt(BannerFragment.IMAGE, content[position])
        }
        return fragment
    }
}