package com.testtask.main_impl.di

import androidx.lifecycle.ViewModel
import com.testtask.main_impl.ui.main.viewmodel.HomeViewModel
import com.testtask.utils.AssistedSavedStateViewModelFactory
import com.testtask.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HomeViewModelFactoriesModule {

    @Binds
    @[IntoMap ViewModelKey(HomeViewModel::class)]
    fun bindHomeViewModelFactory(impl: HomeViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>

}
