package com.testtask.persistence_impl.di

import com.testtask.persistence.anonymous_user.TokenLocalDataSource
import com.testtask.persistence_impl.anonymous_user.local.RoomTokenDataSource
import dagger.Binds
import dagger.Module

@Module
interface LocalDataSourceModule {

    @Binds
    fun bindTokenLocalDataSource(impl: RoomTokenDataSource): TokenLocalDataSource

}