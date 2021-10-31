package com.testtask.navigation_impl.di

import androidx.fragment.app.Fragment
import com.testtask.core_di.ApplicationProvider

val Fragment.injector: NavigationComponent
    get() {
        val appProvider = (requireActivity().application as ApplicationProvider).appProvider
        return NavigationComponent.create(appProvider)
    }