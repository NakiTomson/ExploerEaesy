package com.testtask.main_impl.di

import com.testtask.core_di.AppProvider
import com.testtask.main_impl.ui.main.view.MainFragment
import com.testtask.main_impl.ui.main.viewmodel.MainViewModel
import dagger.Component

@Component(
    dependencies = [AppProvider::class],
    modules = [MainViewModelFactoriesModule::class]
)
@MainScope
interface MainComponent {

    fun inject(fragment: MainFragment)

    fun mainViewModel(): MainViewModel.Factory

    companion object {

        fun create(appProvider: AppProvider): MainComponent {
            return DaggerMainComponent.builder()
                .appProvider(appProvider)
                .build()
        }
    }
}