package com.example.user.di

import com.example.user.ui.user.model.UserViewModel
import com.example.user.ui.user.view.UserFragment
import com.testtask.core_di.AppProvider
import dagger.Component

@User
@Component(dependencies = [AppProvider::class], modules = [UserViewModelFactoriesModule::class])
interface UserComponent {

    fun inject(fragment: UserFragment)

    fun viewModelFactory(): UserViewModel.Factory

    companion object {

        fun create(appProvider: AppProvider): UserComponent {
            return DaggerUserComponent
                .builder()
                .appProvider(appProvider)
                .build()
        }
    }
}