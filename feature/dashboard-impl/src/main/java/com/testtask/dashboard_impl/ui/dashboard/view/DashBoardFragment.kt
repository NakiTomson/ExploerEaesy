package com.testtask.dashboard_impl.ui.dashboard.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.testtask.base.BaseFragment
import com.testtask.dashboard_impl.R
import com.testtask.dashboard_impl.adapter.ViewPagerAdapter
import com.testtask.dashboard_impl.di.injector
import com.testtask.dashboard_impl.ui.dashboard.model.DashBoardViewModel
import com.testtask.dashboard_impl.ui.dashboard.state.DashBoardEvent.CloseDashBoard
import com.testtask.entity.DashBoardScreenEntity
import com.testtask.base_ext.subscribeEvent
import com.testtask.base_ext.subscribeState
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
        setNavController()
        setUiAction()
        handlerUiEvent()
        handlerUiState()
    }

    private fun setNavController() {
        navController = findNavController()
    }

    private fun setUiAction() {
        buttonNext.setOnClickListener { viewModel.onButtonNextClicked() }
        buttonBack.setOnClickListener { viewModel.onButtonBackClicked() }
        buttonTryAgain.setOnClickListener { viewModel.onButtonTryAgainClicked() }
    }

    private fun handlerUiEvent() {
        subscribeEvent(Lifecycle.State.RESUMED) {
            when (this) {
                is CloseDashBoard -> closeDashBoard()
            }
        }
    }

    private fun handlerUiState() {
        subscribeState(Lifecycle.State.CREATED) {
            showLoading.onEach { showLoading(it) }.launchIn(lifecycleScope)
            showError.onEach { showErrorScreen(it) }.launchIn(lifecycleScope)
            showEmpty.onEach { showEmptyScreen(it) }.launchIn(lifecycleScope)
            refreshButton.onEach { showRefreshButton(it) }.launchIn(lifecycleScope)
            showDashBoards.onEach { setupPagerViews(it) }.launchIn(lifecycleScope)
            showDashBoardNavigation.onEach { showBashBoardNavigation(it) }.launchIn(lifecycleScope)
            screenPosition.onEach { setScreenPosition(it) }.launchIn(lifecycleScope)
        }
    }


    private fun showLoading(isLoading: Boolean) {
        dashBoardProgress.isVisible = isLoading
    }


    private fun showErrorScreen(isError: Boolean) {
        groupError.isVisible = isError
    }

    private fun showEmptyScreen(isEmpty: Boolean) {
        groupEmpty.isVisible = isEmpty
    }

    private fun showRefreshButton(isVisible: Boolean) {
        buttonTryAgain.isVisible = isVisible
    }

    private fun setupPagerViews(onBoardingPages: List<DashBoardScreenEntity>) {
        welcomePager.apply {
            isUserInputEnabled = false
            adapter = ViewPagerAdapter(onBoardingPages, childFragmentManager, viewLifecycleOwner.lifecycle)
            offscreenPageLimit = onBoardingPages.size
        }
        plvCounter.setLinesCount(onBoardingPages.count())
    }

    private fun showBashBoardNavigation(isShow: Boolean) {
        buttonNext.isVisible = isShow
        buttonBack.isVisible = isShow
        plvCounter.isVisible = isShow
    }

    private fun setScreenPosition(position: Int) {
        plvCounter.selectLine(position)
        welcomePager.currentItem = position
    }

    private fun closeDashBoard() {
        val navOptions = navOptions {
            popUpTo(R.id.navigationFragment) { inclusive = true }
        }
        navController?.navigate(R.id.navigationFragment, null, navOptions)
    }

    companion object {

        fun create() = DashBoardFragment()
    }
}