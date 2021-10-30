package com.testtask.navigation_impl

import androidx.fragment.app.Fragment
import com.testtask.navigation.NavigationFeatureApi
import com.testtask.navigation_impl.ui.NavigationFragment

class NavigationFeatureApiImpl : NavigationFeatureApi {
    override fun getNavigation(): Fragment {
        return NavigationFragment()
    }
}