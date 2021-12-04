package com.testtask.dashboard_impl.di

import androidx.fragment.app.Fragment
import com.testtask.feature_core.appComponent

val Fragment.injector: DashBoardComponent
    get() = DashBoardComponent.create(requireContext().appComponent)