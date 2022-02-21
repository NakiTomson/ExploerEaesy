package com.testtask.main_impl.di

import androidx.fragment.app.Fragment
import com.testtask.utils.appComponent

val Fragment.injector: HomeComponent
    get() = HomeComponent.create(requireContext().appComponent)
