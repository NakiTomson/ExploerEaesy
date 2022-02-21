package com.testtask.core_ui.navigation

import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator
import com.testtask.core_ui.R


fun NavControllerTop.navigateInDashBoardFragment(
    navOptions: NavOptions = devOptions,
    extras: FragmentNavigator.Extras? = null,
) {
    val bundle = bundleOf()
    navController.navigate(R.id.dashBoardFragment, bundle, navOptions, extras)
}

fun NavControllerTop.navigateInNavigationFragment(
    navOptions: NavOptions = devOptions,
    extras: FragmentNavigator.Extras? = null,
) {
    val bundle = bundleOf()
    navController.navigate(R.id.navigationFragment, bundle, navOptions, extras)
}
