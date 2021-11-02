package com.example.user.di

import androidx.lifecycle.ViewModel
import com.example.user.ui.user.model.UserViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import com.testtask.feature_core.AssistedSavedStateViewModelFactory
import com.testtask.feature_core.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@AssistedModule
@Module(includes = [AssistedInject_UserViewModelFactoriesModule::class])
interface UserViewModelFactoriesModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    fun bindUserViewModelFactory(impl: UserViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>

}