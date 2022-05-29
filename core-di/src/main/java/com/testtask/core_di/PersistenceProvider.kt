package com.testtask.core_di

import com.testtask.persistence.anonymous_user.TokenLocalDataSource
import com.testtask.persistence.dash_board.DashBoardLocalDataSource

interface PersistenceProvider {

    fun provideTokenLocalDataSource(): TokenLocalDataSource

    fun provideDashBoardLocalDataSource(): DashBoardLocalDataSource
}