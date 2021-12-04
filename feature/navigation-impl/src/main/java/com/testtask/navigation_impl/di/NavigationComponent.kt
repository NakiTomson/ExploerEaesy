package com.testtask.navigation_impl.di

import com.testtask.core_di.AppProvider
import com.testtask.navigation_impl.ui.view.NavigationFragment
import com.testtask.navigation_impl.ui.viewModel.NavigationViewModel
import dagger.Component

@Component(
    dependencies = [AppProvider::class],
    modules = [NavigationViewModelFactoriesModule::class]
)
@Navigation
interface NavigationComponent {

    fun inject(fragment: NavigationFragment)

    companion object {

        fun create(appProvider: AppProvider): NavigationComponent {
            return DaggerNavigationComponent
                .builder()
                .appProvider(appProvider)
                .build()
        }
    }
}