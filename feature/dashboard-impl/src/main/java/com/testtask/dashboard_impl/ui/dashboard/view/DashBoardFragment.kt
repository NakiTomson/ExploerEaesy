package com.testtask.dashboard_impl.ui.dashboard.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.testtask.core_ui.NavigationState
import com.testtask.core_ui.Navigator
import com.testtask.core_ui.utils.launchWhenStarted
import com.testtask.dashboard_impl.R
import com.testtask.dashboard_impl.adapter.ViewPagerAdapter
import com.testtask.dashboard_impl.di.injector
import com.testtask.dashboard_impl.ui.dashboard.model.DashBoardViewModel
import com.testtask.entity.BoardScreenEntity
import com.testtask.feature_core.lazyViewModel
import kotlinx.android.synthetic.main.dashborad_fragment.*
import kotlinx.coroutines.flow.onEach

class DashBoardFragment : Fragment(R.layout.dashborad_fragment) {

    private val viewModel: DashBoardViewModel by lazyViewModel { stateHandle ->
        injector.dashBoardViewModel().create(stateHandle)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.apply {
            dashBoardScreens.onEach {
                setupPagerViews(it)
            }.launchWhenStarted(lifecycleScope)
            selectPage.onEach {
                setScreenPosition(it)
            }.launchWhenStarted(lifecycleScope)
            closeDashBoard.onEach {
                closeDashBoard(it)
            }.launchWhenStarted(lifecycleScope)
        }
        tvNext.setOnClickListener {
            viewModel.onNextClicked()
        }
        tvBack.setOnClickListener {
            viewModel.onBackClicked()
        }
    }

    private fun setupPagerViews(onBoardingPages: List<BoardScreenEntity>) {
        plvCounter.setLinesCount(onBoardingPages.count())
        welcomePager.apply {
            isUserInputEnabled = false
            adapter = ViewPagerAdapter(onBoardingPages, childFragmentManager, viewLifecycleOwner.lifecycle)
            offscreenPageLimit = onBoardingPages.size
        }
    }

    private fun closeDashBoard(close: Boolean) {
        if (close) (requireActivity() as Navigator).navigate(NavigationState.NavigationFragment)
    }

    private fun setScreenPosition(position: Int) {
        plvCounter.selectLine(position)
        welcomePager.currentItem = position
    }

    companion object {

        fun create() = DashBoardFragment()
    }
}