package com.testtask.splash_impl.ui.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.testtask.base.BaseFragment
import com.testtask.base_ext.subscribeState
import com.testtask.core_ui.navigation.findTopNavController
import com.testtask.core_ui.navigation.navigateInDashBoardFragment
import com.testtask.splash_impl.R
import com.testtask.splash_impl.di.injector
import com.testtask.splash_impl.ui.model.SplashViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SplashFragment : BaseFragment<SplashViewModel>(R.layout.splash_fragment) {

    override val viewModel: SplashViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handlerUiState()
        handlerUiEvent()
    }

    private fun handlerUiState() {
        subscribeState(Lifecycle.State.CREATED) {
            openDashBoard.onEach {
                navigateInDashBoardFragment()
            }.launchIn(lifecycleScope)
        }
    }

    private fun navigateInDashBoardFragment() {
        findTopNavController().navigateInDashBoardFragment()
    }

    private fun handlerUiEvent() {

    }
}