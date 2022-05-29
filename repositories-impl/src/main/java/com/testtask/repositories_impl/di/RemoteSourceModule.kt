package com.testtask.repositories_impl.di

import com.testtask.repositories_impl.dashboard.source.DashBoardRetrofitDataSource
import com.testtask.repositories_impl.token.source.TokenRetrofitDataSource
import com.testtask.source.DashBoardRemoteDataSource
import com.testtask.source.TokenRemoteDataSource
import dagger.Binds
import dagger.Module

@Module
interface RemoteSourceModule {


    @Binds
    fun bindTokenRemoteDataSource(impl: TokenRetrofitDataSource): TokenRemoteDataSource

    @Binds
    fun bindDashBoardRemoteDataSource(impl: DashBoardRetrofitDataSource): DashBoardRemoteDataSource
}