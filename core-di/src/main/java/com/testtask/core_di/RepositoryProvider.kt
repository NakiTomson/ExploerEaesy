package com.testtask.core_di

import com.testtask.repositories.DashBoardRepository
import com.testtask.repositories.TokenRepository
import com.testtask.source.DashBoardRemoteDataSource
import com.testtask.source.TokenRemoteDataSource

interface RepositoryProvider {

    fun provideDashBoardRepository(): DashBoardRepository
    fun provideDashBoardDataSource(): DashBoardRemoteDataSource

    fun provideTokenRepository(): TokenRepository
    fun provideTokenRemoteDataSource(): TokenRemoteDataSource
}
