package com.testtask.interactors_impl.di

import com.testtask.interactors.DashBoardInteractor
import com.testtask.interactors.SplashInteractor
import com.testtask.interactors_impl.DashBoardInteractorImpl
import com.testtask.interactors_impl.SplashInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface InteractorsModule {

    @Binds
    fun bindSplashInteractor(impl: SplashInteractorImpl): SplashInteractor

    @Binds
    fun bindDashBoardInteractor(impl: DashBoardInteractorImpl): DashBoardInteractor
}