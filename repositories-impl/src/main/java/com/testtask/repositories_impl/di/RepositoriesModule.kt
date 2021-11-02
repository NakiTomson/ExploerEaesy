package com.testtask.repositories_impl.di

import com.testtask.repositories.DashBoardRepository
import com.testtask.repositories_impl.DashBoardRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {

    @Binds
    fun bindDashBoardRepository(impl: DashBoardRepositoryImpl): DashBoardRepository
}