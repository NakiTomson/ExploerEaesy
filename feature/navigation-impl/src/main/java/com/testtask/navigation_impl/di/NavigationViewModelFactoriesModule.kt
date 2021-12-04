package com.testtask.navigation_impl.di

import androidx.lifecycle.ViewModel
import com.testtask.feature_core.AssistedSavedStateViewModelFactory
import com.testtask.feature_core.ViewModelKey
import com.testtask.navigation_impl.ui.viewModel.NavigationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface NavigationViewModelFactoriesModule {

    @Binds
    @IntoMap
    @ViewModelKey(NavigationViewModel::class)
    fun bindNavigationViewModelFactory(impl: NavigationViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>

}