package com.testtask.interactors_impl.di

import com.testtask.interactors.DashBoardInteractor
import com.testtask.interactors.TokenInteractor
import com.testtask.interactors_impl.DashBoardInteractorImpl
import com.testtask.interactors_impl.TokenInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface InteractorsModule {

    @Binds
    fun bindSplashInteractor(impl: TokenInteractorImpl): TokenInteractor

    @Binds
    fun bindDashBoardInteractor(impl: DashBoardInteractorImpl): DashBoardInteractor
}