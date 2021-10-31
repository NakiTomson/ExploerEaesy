package com.testtask.splash_impl.ui.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.testtask.core_ui.NavigationState
import com.testtask.core_ui.Navigator
import com.testtask.splash_impl.R
import com.testtask.splash_impl.ui.model.SplashViewModel
import kotlinx.android.synthetic.main.splash_fragment.*

class SplashFragment : Fragment(R.layout.splash_fragment) {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rootSplash.setOnClickListener {
            (requireActivity() as Navigator).navigate(NavigationState.DashboardFragment)
        }
    }

    companion object {
        fun create() = SplashFragment()
        const val SPLASH_FRAGMENT = "SplashFragment"
        const val SPLASH_RESULT = "SplashResult"
    }
}