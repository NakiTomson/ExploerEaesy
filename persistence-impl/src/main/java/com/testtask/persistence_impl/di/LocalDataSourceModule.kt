package com.testtask.persistence_impl.di

import com.testtask.persistence.anonymous_user.TokenLocalDataSource
import com.testtask.persistence.dash_board.DashBoardLocalDataSource
import com.testtask.persistence_impl.anonymous_user.local.RoomTokenDataSource
import com.testtask.persistence_impl.dashboard.local.RoomDashBoardDataSource
import dagger.Binds
import dagger.Module

@Module
interface LocalDataSourceModule {

    @Binds
    fun bindTokenLocalDataSource(impl: RoomTokenDataSource): TokenLocalDataSource

    @Binds
    fun bindDashBoardLocalDataSource(impl: RoomDashBoardDataSource): DashBoardLocalDataSource

}