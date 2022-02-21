package com.testtask.navigation_impl.di

import androidx.lifecycle.ViewModel
import com.testtask.utils.AssistedSavedStateViewModelFactory
import com.testtask.utils.ViewModelKey
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