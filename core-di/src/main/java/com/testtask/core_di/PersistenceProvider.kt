package com.testtask.core_di

import com.testtask.persistence.anonymous_user.TokenLocalDataSource
import com.testtask.persistence.anonymous_user.TokenRemoteDataSource

interface PersistenceProvider {

    fun provideTokenRemoteDataSource(): TokenRemoteDataSource
    fun provideTokenLocalDataSource(): TokenLocalDataSource
}