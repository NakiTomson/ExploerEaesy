package com.testtask.exploereaesy

import android.app.Application
import com.testtask.core_di.AppProvider
import com.testtask.core_di.ApplicationProvider
import com.testtask.exploereaesy.di.AppComponent
import com.testtask.exploereaesy.di.ContextComponent

class EaesyApp : Application(), ApplicationProvider {

    override lateinit var appProvider: AppProvider

    override fun onCreate() {
        super.onCreate()
        setupDI()
    }

    private fun setupDI() {
        val contextComponent = ContextComponent.create(this)
        appProvider = AppComponent.create(
            contextComponent
        )
    }
}