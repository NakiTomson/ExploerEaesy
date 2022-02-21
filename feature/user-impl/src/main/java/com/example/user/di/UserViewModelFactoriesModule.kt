package com.example.user.di

import androidx.lifecycle.ViewModel
import com.example.user.ui.user.model.UserViewModel
import com.testtask.utils.AssistedSavedStateViewModelFactory
import com.testtask.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface UserViewModelFactoriesModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    fun bindUserViewModelFactory(impl: UserViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>

}