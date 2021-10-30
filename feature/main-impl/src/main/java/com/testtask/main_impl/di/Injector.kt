package com.testtask.main_impl.di

import androidx.fragment.app.Fragment
import com.testtask.core_di.ApplicationProvider

val Fragment.injector: MainComponent
    get() {
        val appProvider = (requireActivity().application as ApplicationProvider).appProvider
        return MainComponent.create(appProvider)
    }
