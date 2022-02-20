package com.example.base_impl.di

import androidx.fragment.app.Fragment
import com.testtask.utils.appComponent

val Fragment.injector: FeatureBaseComponent
    get() = FeatureBaseComponent.create(requireContext().appComponent)