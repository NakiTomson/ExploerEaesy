package com.testtask.dashboard_impl.di

import androidx.lifecycle.ViewModel
import com.testtask.dashboard_impl.ui.dashboard.model.DashBoardViewModel
import com.testtask.dashboard_impl.ui.dashboard_page.model.DashBoardPageViewModel
import com.testtask.utils.AssistedSavedStateViewModelFactory
import com.testtask.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DashBoardViewModelFactoriesModule {


    @Binds
    @[IntoMap ViewModelKey(DashBoardViewModel::class)]
    fun bindDashBordViewModelFactory(impl: DashBoardViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>

    @Binds
    @[IntoMap ViewModelKey(DashBoardPageViewModel::class)]
    fun bindDashBordPageViewModelFactory(impl: DashBoardPageViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>
}