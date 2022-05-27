package com.testtask.repositories_impl.di

import com.testtask.repositories.TokenRepository
import com.testtask.repositories.DashBoardRepository
import com.testtask.repositories_impl.TokenRepositoryImpl
import com.testtask.repositories_impl.DashBoardRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {

    @Binds
    fun bindDashBoardRepository(impl: DashBoardRepositoryImpl): DashBoardRepository

    @Binds
    fun bindTokenRepository(impl: TokenRepositoryImpl): TokenRepository
}