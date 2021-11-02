package com.testtask.splash_impl.di

import androidx.fragment.app.Fragment
import com.testtask.core_di.ApplicationProvider

val Fragment.injector: SplashComponent
    get() {
        val appProvider = (requireActivity().application as ApplicationProvider).appProvider
        return SplashComponent.create(appProvider)
    }