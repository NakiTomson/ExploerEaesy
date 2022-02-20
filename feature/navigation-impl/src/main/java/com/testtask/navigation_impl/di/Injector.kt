package com.testtask.navigation_impl.di

import androidx.fragment.app.Fragment
import com.testtask.utils.appComponent

val Fragment.injector: NavigationComponent
    get() = NavigationComponent.create(requireContext().appComponent)