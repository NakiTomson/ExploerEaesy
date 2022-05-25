package com.example.base_impl.di

import androidx.lifecycle.ViewModel
import com.example.base_impl.ui.empty.viewmodel.EmptyDialogViewModel
import com.example.base_impl.ui.error.viewmodel.ErrorDialogViewModel
import com.testtask.utils.AssistedSavedStateViewModelFactory
import com.testtask.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface BaseFeatureViewModelFactoriesModule {


    @Binds
    @[IntoMap ViewModelKey(ErrorDialogViewModel::class)]
    fun bindErrorViewModelFactory(impl: ErrorDialogViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>

    @Binds
    @[IntoMap ViewModelKey(EmptyDialogViewModel::class)]
    fun bindEmptyViewModelFactory(impl: EmptyDialogViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>
}