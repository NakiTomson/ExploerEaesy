package com.testtask.core_ui

interface DirectionsNavigation {
    fun navigate(nav: NavigationAction)
}

sealed class NavigationAction {

    object DashBoard : NavigationAction()
    object Menu : NavigationAction()
}