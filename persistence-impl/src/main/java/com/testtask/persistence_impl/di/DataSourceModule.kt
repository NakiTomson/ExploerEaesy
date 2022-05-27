package com.testtask.persistence_impl.di

import com.testtask.persistence.anonymous_user.TokenLocalDataSource
import com.testtask.persistence.anonymous_user.TokenRemoteDataSource
import com.testtask.persistence_impl.anonymous_user.local.RoomTokenDataSource
import com.testtask.persistence_impl.anonymous_user.remote.RetrofitTokenDataSource
import dagger.Binds
import dagger.Module

@Module
interface DataSourceModule {

    @Binds
    fun bindTokenLocalDataSource(impl: RoomTokenDataSource): TokenLocalDataSource

    @Binds
    fun bindTokenRemoteDataSource(impl: RetrofitTokenDataSource): TokenRemoteDataSource

}