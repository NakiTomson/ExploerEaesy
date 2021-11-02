package com.testtask.core_ui

interface Navigator {
    fun navigate(state: NavigationState)
}

sealed class NavigationState {
    object DashboardFragment : NavigationState()
    object NavigationFragment : NavigationState()
}