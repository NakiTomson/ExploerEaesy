package com.testtask.main_impl.di

import androidx.fragment.app.Fragment
import com.testtask.core_di.ApplicationProvider

val Fragment.injector: HomeComponent
    get() {
        val appProvider = (requireActivity().application as ApplicationProvider).appProvider
        return HomeComponent.create(appProvider)
    }
