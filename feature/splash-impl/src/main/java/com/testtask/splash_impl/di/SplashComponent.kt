package com.testtask.splash_impl.di

import com.testtask.core_di.AppProvider
import com.testtask.splash_impl.ui.model.SplashViewModel
import com.testtask.splash_impl.ui.view.SplashFragment
import dagger.Component


@Splash
@Component(dependencies = [AppProvider::class], modules = [SplashViewModelFactoriesModule::class])
interface SplashComponent {

    fun inject(fragment: SplashFragment)

    companion object {

        fun create(appProvider: AppProvider): SplashComponent {
            return DaggerSplashComponent
                .builder()
                .appProvider(appProvider)
                .build()
        }
    }
}