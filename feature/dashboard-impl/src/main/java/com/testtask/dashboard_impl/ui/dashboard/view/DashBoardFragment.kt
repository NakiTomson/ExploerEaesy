package com.testtask.dashboard_impl.ui.dashboard.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.testtask.base.BaseFragment
import com.testtask.core_ui.utils.launchWhenStarted
import com.testtask.dashboard_impl.R
import com.testtask.dashboard_impl.adapter.ViewPagerAdapter
import com.testtask.dashboard_impl.di.injector
import com.testtask.dashboard_impl.ui.dashboard.model.DashBoardViewModel
import com.testtask.entity.BoardScreenEntity
import com.testtask.feature_core.lazyViewModel
import kotlinx.android.synthetic.main.dashborad_fragment.*
import kotlinx.coroutines.flow.onEach

class DashBoardFragment : BaseFragment(R.layout.dashborad_fragment) {

    private val viewModel: DashBoardViewModel by viewModels()

    private var navController: NavController? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
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
        if (close) {
            navController?.navigate(R.id.navigationFragment)
        }
    }

    private fun setScreenPosition(position: Int) {
        plvCounter.selectLine(position)
        welcomePager.currentItem = position
    }

    companion object {

        fun create() = DashBoardFragment()

    }
}