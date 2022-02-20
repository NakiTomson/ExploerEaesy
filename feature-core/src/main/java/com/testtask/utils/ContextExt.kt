package com.testtask.utils

import android.content.Context
import com.testtask.core_di.AppProvider
import com.testtask.core_di.ApplicationProvider

val Context.appComponent: AppProvider
    get() = when (this) {
        is ApplicationProvider -> appProvider
        else -> this.applicationContext.appComponent
    }