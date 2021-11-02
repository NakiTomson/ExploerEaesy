package com.testtask.main_impl.di

import com.testtask.core_di.AppProvider
import com.testtask.main_impl.ui.main.view.HomeFragment
import com.testtask.main_impl.ui.main.viewmodel.HomeViewModel
import dagger.Component

@Component(
    dependencies = [AppProvider::class],
    modules = [HomeViewModelFactoriesModule::class]
)
@HomeScope
interface HomeComponent {

    fun inject(fragment: HomeFragment)

    fun mainViewModel(): HomeViewModel.Factory

    companion object {

        fun create(appProvider: AppProvider): HomeComponent {
            return DaggerHomeComponent.builder()
                .appProvider(appProvider)
                .build()
        }
    }
}