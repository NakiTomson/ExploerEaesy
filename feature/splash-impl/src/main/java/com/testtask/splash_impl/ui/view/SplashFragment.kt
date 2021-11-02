package com.testtask.splash_impl.ui.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.testtask.core_ui.NavigationState
import com.testtask.core_ui.Navigator
import com.testtask.core_ui.utils.NetworkConnection
import com.testtask.core_ui.utils.launchWhenStarted
import com.testtask.feature_core.lazyViewModel
import com.testtask.splash_impl.R
import com.testtask.splash_impl.di.injector
import com.testtask.splash_impl.ui.model.SplashViewModel
import kotlinx.coroutines.flow.onEach

class SplashFragment : Fragment(R.layout.splash_fragment) {

    private val viewModel: SplashViewModel by lazyViewModel { stateHandle ->
        injector.viewModelFactory().create(stateHandle)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.apply {
            openDashBoard.onEach {
                (requireActivity() as Navigator).navigate(NavigationState.DashboardFragment)
            }.launchWhenStarted(lifecycleScope)
        }
        changeNetworkState()
    }

    private fun changeNetworkState() {
        NetworkConnection(context?.applicationContext!!).observe(viewLifecycleOwner) {

        }
    }


    companion object {
        fun create() = SplashFragment()
    }
}