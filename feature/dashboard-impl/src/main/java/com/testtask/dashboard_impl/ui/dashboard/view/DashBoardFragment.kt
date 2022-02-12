package com.testtask.dashboard_impl.ui.dashboard.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.testtask.base.BaseFragment
import com.testtask.dashboard_impl.R
import com.testtask.dashboard_impl.adapter.ViewPagerAdapter
import com.testtask.dashboard_impl.di.injector
import com.testtask.dashboard_impl.ui.dashboard.model.DashBoardViewModel
import com.testtask.entity.BoardScreenEntity
import com.testtask.ext.subscribeState
import kotlinx.android.synthetic.main.dashborad_fragment.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class DashBoardFragment : BaseFragment<DashBoardViewModel>(R.layout.dashborad_fragment) {

    override val viewModel: DashBoardViewModel by viewModels()

    private var navController: NavController? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        subscribeState(Lifecycle.State.RESUMED) {
            dashBoardScreens.onEach { setupPagerViews(it) }.launchIn(this)
            selectPage.onEach { setScreenPosition(it) }.launchIn(this)
            closeDashBoard.onEach { closeDashBoard() }.launchIn(this)
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

    private fun closeDashBoard() {
        val navOptions = navOptions {
            popUpTo(R.id.navigationFragment) { inclusive = true }
        }
        navController?.navigate(R.id.navigationFragment, null, navOptions)
    }

    private fun setScreenPosition(position: Int) {
        plvCounter.selectLine(position)
        welcomePager.currentItem = position
    }

    companion object {

        fun create() = DashBoardFragment()

    }
}