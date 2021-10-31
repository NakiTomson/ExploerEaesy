package com.testtask.navigation_impl.di

import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import com.testtask.feature_core.AssistedSavedStateViewModelFactory
import com.testtask.feature_core.ViewModelKey
import com.testtask.navigation_impl.ui.viewModel.NavigationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@AssistedModule
@Module(includes = [AssistedInject_NavigationViewModelFactoriesModule::class])
interface NavigationViewModelFactoriesModule {

    @Binds
    @IntoMap
    @ViewModelKey(NavigationViewModel::class)
    fun bindNavigationViewModelFactory(impl: NavigationViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>

}