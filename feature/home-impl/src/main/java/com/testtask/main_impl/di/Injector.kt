package com.testtask.main_impl.di

import androidx.fragment.app.Fragment
import com.testtask.core_di.ApplicationProvider
import com.testtask.feature_core.appComponent

val Fragment.injector: HomeComponent
    get() = HomeComponent.create(requireContext().appComponent)
