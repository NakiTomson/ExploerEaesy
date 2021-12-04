package com.testtask.splash_impl.ui.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.testtask.base.BaseFragment
import com.testtask.core_ui.utils.NetworkConnection
import com.testtask.core_ui.utils.launchWhenStarted
import com.testtask.splash_impl.R
import com.testtask.splash_impl.di.injector
import com.testtask.splash_impl.ui.model.SplashViewModel
import kotlinx.coroutines.flow.onEach

class SplashFragment : BaseFragment(R.layout.splash_fragment) {

    private val viewModel: SplashViewModel by viewModels()

    private var navController: NavController? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        viewModel.apply {
            openDashBoard.onEach {
                navController?.navigate(R.id.dashBoardFragment)
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