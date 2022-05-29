package com.testtask.repositories_impl.di

import com.testtask.repositories.DashBoardRepository
import com.testtask.repositories.TokenRepository
import com.testtask.repositories_impl.dashboard.DashBoardRepositoryImpl
import com.testtask.repositories_impl.token.TokenRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {

    @Binds
    fun bindDashBoardRepository(impl: DashBoardRepositoryImpl): DashBoardRepository

    @Binds
    fun bindTokenRepository(impl: TokenRepositoryImpl): TokenRepository
}