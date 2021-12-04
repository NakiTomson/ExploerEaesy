package com.testtask.splash_impl.di

import androidx.lifecycle.ViewModel
import com.testtask.feature_core.AssistedSavedStateViewModelFactory
import com.testtask.feature_core.ViewModelKey
import com.testtask.splash_impl.ui.model.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface SplashViewModelFactoriesModule {


    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindSplashViewModelFactory(impl: SplashViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>

}