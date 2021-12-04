package com.testtask.dashboard_impl.di

import androidx.lifecycle.ViewModel
import com.testtask.dashboard_impl.ui.dashboard.model.DashBoardViewModel
import com.testtask.feature_core.AssistedSavedStateViewModelFactory
import com.testtask.feature_core.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DashBoardViewModelFactoriesModule {


    @Binds
    @IntoMap
    @ViewModelKey(DashBoardViewModel::class)
    fun bindDashBordViewModelFactory(impl: DashBoardViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>
}