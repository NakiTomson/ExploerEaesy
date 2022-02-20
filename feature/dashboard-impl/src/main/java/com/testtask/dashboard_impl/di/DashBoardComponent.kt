package com.testtask.dashboard_impl.di

import com.testtask.core_di.AppProvider
import com.testtask.dashboard_impl.ui.dashboard.view.DashBoardFragment
import dagger.Component

@Component(
    dependencies = [AppProvider::class],
    modules = [DashBoardViewModelFactoriesModule::class]
)
@DashBoardScope
interface DashBoardComponent {

    fun inject(fragment: DashBoardFragment)

    companion object {

        fun create(appProvider: AppProvider): DashBoardComponent {
            return DaggerDashBoardComponent.builder()
                .appProvider(appProvider)
                .build()
        }
    }
}
