package com.testtask.dashboard_impl.ui.dashboard.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.example.base.BaseFeatureApi
import com.example.controller.EmptyDialogListener
import com.example.controller.ErrorDialogListener
import com.testtask.base.BaseFragment
import com.testtask.base_ext.subscribeEvent
import com.testtask.base_ext.subscribeState
import com.testtask.core_ui.navigation.findTopNavController
import com.testtask.core_ui.navigation.navigateInNavigationFragment
import com.testtask.dashboard_impl.R
import com.testtask.dashboard_impl.adapter.ViewPagerAdapter
import com.testtask.dashboard_impl.di.injector
import com.testtask.dashboard_impl.ui.dashboard.event.DashBoardEvent.CloseDashBoard
import com.testtask.dashboard_impl.ui.dashboard.model.DashBoardViewModel
import com.testtask.entity.DashBoardScreenEntity
import kotlinx.android.synthetic.main.dashborad_fragment.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class DashBoardFragment : BaseFragment<DashBoardViewModel>(R.layout.dashborad_fragment), ErrorDialogListener,
    EmptyDialogListener {

    override val viewModel: DashBoardViewModel by viewModels()

    @Inject
    lateinit var baseFeatureApi: BaseFeatureApi

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUiAction()
        handlerUiEvent()
        handlerUiState()
    }

    private fun setUiAction() {
        buttonNext.setOnClickListener { viewModel.onButtonNextClicked() }
        buttonBack.setOnClickListener { viewModel.onButtonBackClicked() }
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
            showLoading.onEach { showLoading(it) }.launchIn(viewLifecycleOwner.lifecycleScope)
            showError.onEach { showErrorScreen(it) }.launchIn(viewLifecycleOwner.lifecycleScope)
            showEmpty.onEach { showEmptyScreen(it) }.launchIn(viewLifecycleOwner.lifecycleScope)
            showDashBoards.onEach { setupPagerViews(it) }.launchIn(viewLifecycleOwner.lifecycleScope)
            showDashBoardNavigation.onEach { showBashBoardNavigation(it) }.launchIn(viewLifecycleOwner.lifecycleScope)
            screenPosition.onEach { setScreenPosition(it) }.launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }

    private fun showLoading(isLoading: Boolean) {
        dashBoardProgress.isVisible = isLoading
    }

    private fun showErrorScreen(isError: Boolean) {
        baseFeatureApi.showErrorDialogOrClose(isError, childFragmentManager)
    }

    private fun showEmptyScreen(isEmpty: Boolean) {
        baseFeatureApi.showEmptyDialogOrClose(isEmpty, childFragmentManager)
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
        findTopNavController().navigateInNavigationFragment()
    }

    override fun closeEmptyFragment() {
        viewModel.onLoadTryAgain()
    }

    override fun closeErrorFragment() {
        viewModel.onLoadTryAgain()
    }

    companion object {

        fun create() = DashBoardFragment()
    }
}