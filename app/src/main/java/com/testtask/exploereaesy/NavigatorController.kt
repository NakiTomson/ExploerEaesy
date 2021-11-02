package com.testtask.exploereaesy

import androidx.navigation.NavController
import com.testtask.core_ui.NavigationState
import com.testtask.splash_impl.ui.view.SplashFragmentDirections

class NavigatorController {

    lateinit var navController: NavController

    fun navigateToFlow(state: NavigationState) = when (state) {
        is NavigationState.DashboardFragment -> navController.navigate(SplashFragmentDirections.actionSplashFragmentToDashBoardFragment())
        is NavigationState.NavigationFragment -> {
            navController.navigate(SplashFragmentDirections.actionGlobalNavigationFragment())
        }
    }
}