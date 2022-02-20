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
import com.example.base.BaseFeatureApi
import com.example.base.BaseFeatureApi.Companion.EMPTY_DIALOG_TAG
import com.example.base.BaseFeatureApi.Companion.ERROR_DIALOG_TAG
import com.example.controller.EmptyDialogListener
import com.example.controller.ErrorDialogListener
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.testtask.base.BaseFragment
import com.testtask.base_ext.subscribeEvent
import com.testtask.base_ext.subscribeState
import com.testtask.dashboard_impl.R
import com.testtask.dashboard_impl.adapter.ViewPagerAdapter
import com.testtask.dashboard_impl.di.injector
import com.testtask.dashboard_impl.ui.dashboard.model.DashBoardViewModel
import com.testtask.dashboard_impl.ui.dashboard.event.DashBoardEvent.CloseDashBoard
import com.testtask.entity.DashBoardScreenEntity
import kotlinx.android.synthetic.main.dashborad_fragment.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class DashBoardFragment : BaseFragment<DashBoardViewModel>(R.layout.dashborad_fragment), ErrorDialogListener,
    EmptyDialogListener {

    override val viewModel: DashBoardViewModel by viewModels()

    private var navController: NavController? = null

    @Inject
    lateinit var cameraFeatureApi: BaseFeatureApi

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
            showDashBoards.onEach { setupPagerViews(it) }.launchIn(lifecycleScope)
            showDashBoardNavigation.onEach { showBashBoardNavigation(it) }.launchIn(lifecycleScope)
            screenPosition.onEach { setScreenPosition(it) }.launchIn(lifecycleScope)
        }
    }

    private fun showLoading(isLoading: Boolean) {
        dashBoardProgress.isVisible = isLoading
    }

    private fun showErrorScreen(isError: Boolean) {
        childFragmentManager.findFragmentByTag(ERROR_DIALOG_TAG).let {
            if (isError.not()) {
                (it as? BottomSheetDialogFragment)?.dismiss()
                return
            }
            if (it != null) return
        }
        val dialogFragment = cameraFeatureApi.getErrorDialog()
        dialogFragment.show(childFragmentManager, ERROR_DIALOG_TAG)
    }

    private fun showEmptyScreen(isEmpty: Boolean) {
        childFragmentManager.findFragmentByTag(EMPTY_DIALOG_TAG).let {
            if (isEmpty.not()) {
                (it as? BottomSheetDialogFragment)?.dismiss()
                return
            }
            if (it != null) return
        }
        val dialogFragment = cameraFeatureApi.getEmptyDialog()
        dialogFragment.show(childFragmentManager, EMPTY_DIALOG_TAG)
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

    override fun closeErrorFragment() {
        viewModel.onLoadTryAgain()
    }

    companion object {

        fun create() = DashBoardFragment()
    }
}