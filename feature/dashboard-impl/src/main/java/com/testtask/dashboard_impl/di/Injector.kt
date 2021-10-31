package com.testtask.dashboard_impl.di

import androidx.fragment.app.Fragment
import com.testtask.core_di.ApplicationProvider

val Fragment.injector: DashBoardComponent
    get() {
        val appProvider = (requireActivity().application as ApplicationProvider).appProvider
        return DashBoardComponent.create(appProvider)
    }