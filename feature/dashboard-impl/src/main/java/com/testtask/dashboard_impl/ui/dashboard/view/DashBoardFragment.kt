package com.testtask.dashboard_impl.ui.dashboard.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.testtask.base.BaseFragment
import com.testtask.base.BaseState
import com.testtask.dashboard_impl.R
import com.testtask.dashboard_impl.adapter.ViewPagerAdapter
import com.testtask.dashboard_impl.di.injector
import com.testtask.dashboard_impl.ui.dashboard.model.DashBoardViewModel
import com.testtask.dashboard_impl.ui.dashboard.state.DashBoardEvent.CloseDashBoard
import com.testtask.dashboard_impl.ui.dashboard.state.DashBoardState.*
import com.testtask.entity.BoardScreenEntity
import com.testtask.ext.subscribeEvent
import com.testtask.ext.subscribeState
import kotlinx.android.synthetic.main.dashborad_fragment.*

class DashBoardFragment : BaseFragment<DashBoardViewModel>(R.layout.dashborad_fragment) {

    override val viewModel: DashBoardViewModel by viewModels()

    private var navController: NavController? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavController()
        setUiAction()
        handlerUiState()
        handlerUiEvent()
    }

    private fun setNavController() {
        navController = findNavController()
    }

    private fun setUiAction() {
        tvNext.setOnClickListener { viewModel.onNextClicked() }
        tvBack.setOnClickListener { viewModel.onBackClicked() }
    }

    private fun handlerUiState() {
        subscribeState(Lifecycle.State.RESUMED) { renderUi(this) }
    }

    private fun renderUi(baseState: BaseState?) {
        baseState?.subStates?.forEach { renderUi(it) }
        when (baseState) {
            is DashBoardLoadedState -> setupPagerViews(baseState.onBoardingPages)
            is DashBoardLoadingState -> showLoading(baseState.isLoading)
            is DashBoardEmptyState -> showEmptyScreen(baseState.isEmpty)
            is DashBoardErrorState -> showErrorScreen(baseState.isError)
            is DashBoardPositionState -> setScreenPosition(baseState.position)
        }
    }

    private fun handlerUiEvent() {
        subscribeEvent(Lifecycle.State.RESUMED) {
            when (this) {
                is CloseDashBoard -> closeDashBoard()
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        dashBoardProgress.isVisible = isLoading
    }

    private fun showEmptyScreen(isEmpty: Boolean) {

    }

    private fun showErrorScreen(isError: Boolean) {

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