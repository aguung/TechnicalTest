package com.technicaltest.apps.ui.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.technicaltest.apps.R
import com.technicaltest.apps.adapter.MenuAdapter
import com.technicaltest.apps.adapter.ScreenSlidePagerAdapter
import com.technicaltest.apps.data.model.Menu
import com.technicaltest.apps.databinding.FragmentHomeBinding
import com.technicaltest.apps.utils.DepthPageTransformer
import com.technicaltest.apps.utils.SpacingItemDecoration


class HomeFragment : Fragment() {
    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    private lateinit var adapterMenu: MenuAdapter
    private val content = listOf(R.drawable.banner, R.drawable.banner, R.drawable.banner, R.drawable.banner, R.drawable.banner)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
    }

    private fun setupUI() {
        adapterMenu = MenuAdapter()
        binding.rvMenu.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rvMenu.addItemDecoration(SpacingItemDecoration(2, 2, true))
        binding.rvMenu.setHasFixedSize(true)
        binding.rvMenu.isNestedScrollingEnabled = false
        binding.rvMenu.adapter = adapterMenu

        adapterMenu.itemClick(object : MenuAdapter.OnItemClick {
            override fun onItemClicked(item: Menu) {

            }
        })
        fetchMenu()

        val pagerAdapter = ScreenSlidePagerAdapter(this, content)
        binding.viewPager.adapter = pagerAdapter
        binding.viewPager.setPageTransformer(DepthPageTransformer())

        TabLayoutMediator(binding.tabLayout, binding.viewPager)
        { _, _ -> }.attach()
    }

    private fun fetchMenu() {
        val listMenu: ArrayList<Menu> = ArrayList()
        listMenu.add(Menu(nama = "KLINIK TERDEKAT", image = R.drawable.klinik))
        listMenu.add(Menu(nama = "RIWAYAT", image = R.drawable.riwayat))
        listMenu.add(Menu(nama = "DATA SCAN", image = R.drawable.scan))
        listMenu.add(Menu(nama = "NOTIFIKASI", image = R.drawable.notifikasi))
        listMenu.add(Menu(nama = "BERI NILAI", image = R.drawable.nilai))
        listMenu.add(Menu(nama = "PENGATURAN", image = R.drawable.pengaturan))
        adapterMenu.replaceAll(listMenu)
    }


}