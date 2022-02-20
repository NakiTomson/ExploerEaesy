package com.testtask.splash_impl.di

import androidx.fragment.app.Fragment
import com.testtask.utils.appComponent

val Fragment.injector: SplashComponent
    get() = SplashComponent.create(requireContext().appComponent)