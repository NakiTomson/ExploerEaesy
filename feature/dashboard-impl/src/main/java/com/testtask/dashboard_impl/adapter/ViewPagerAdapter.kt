package com.testtask.dashboard_impl.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.testtask.dashboard_impl.ui.dashboard_page.view.BashBoardPageFragment
import com.testtask.entity.BoardScreenEntity

class ViewPagerAdapter(
    private val onBoardingPages: List<BoardScreenEntity>,
    childFragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(childFragmentManager, lifecycle) {

    override fun getItemCount() = onBoardingPages.size

    override fun createFragment(position: Int): Fragment {
        return BashBoardPageFragment.create(onBoardingPages[position])
    }
}