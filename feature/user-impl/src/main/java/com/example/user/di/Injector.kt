package com.example.user.di

import androidx.fragment.app.Fragment
import com.example.user.di.UserComponent
import com.testtask.core_di.ApplicationProvider


val Fragment.injector: UserComponent
    get() {
        val appProvider = (requireActivity().application as ApplicationProvider).appProvider
        return UserComponent.create(appProvider)
    }
