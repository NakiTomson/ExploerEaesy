package com.testtask.core_di

import com.testtask.repositories.DashBoardRepository
import com.testtask.repositories.TokenRepository
import com.testtask.source.TokenRemoteDataSource

interface RepositoryProvider {

    fun provideDashBoardRepository(): DashBoardRepository

    fun provideTokenRepository(): TokenRepository
    fun provideTokenRemoteDataSource(): TokenRemoteDataSource
}
