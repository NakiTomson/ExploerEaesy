package com.testtask.core_di

import com.testtask.repositories.DashBoardRepository
import com.testtask.repositories.TokenRepository

interface RepositoryProvider {

    fun provideDashBoardRepository(): DashBoardRepository
    fun provideTokenRepository(): TokenRepository
}
