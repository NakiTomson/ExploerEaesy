package com.testtask.repositories_impl.di

import com.testtask.repositories_impl.source.RetrofitTokenDataSource
import com.testtask.source.TokenRemoteDataSource
import dagger.Binds
import dagger.Module

@Module
interface RemoteSourceModule {


    @Binds
    fun bindTokenRemoteDataSource(impl: RetrofitTokenDataSource): TokenRemoteDataSource
}