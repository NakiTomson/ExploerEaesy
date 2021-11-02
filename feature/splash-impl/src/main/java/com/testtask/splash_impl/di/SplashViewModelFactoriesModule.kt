package com.testtask.splash_impl.di

import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import com.testtask.feature_core.AssistedSavedStateViewModelFactory
import com.testtask.feature_core.ViewModelKey
import com.testtask.splash_impl.ui.model.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@AssistedModule
@Module(includes = [AssistedInject_SplashViewModelFactoriesModule::class])
interface SplashViewModelFactoriesModule {


    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindSplashViewModelFactory(impl: SplashViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>

}