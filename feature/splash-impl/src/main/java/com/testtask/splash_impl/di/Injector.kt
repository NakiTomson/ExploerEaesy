package com.testtask.splash_impl.di

import androidx.fragment.app.Fragment
import com.testtask.core_di.ApplicationProvider
import com.testtask.feature_core.appComponent

val Fragment.injector: SplashComponent
    get() = SplashComponent.create(requireContext().appComponent)