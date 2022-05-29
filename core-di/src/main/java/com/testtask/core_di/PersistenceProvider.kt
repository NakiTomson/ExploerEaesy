package com.testtask.core_di

import com.testtask.persistence.anonymous_user.TokenLocalDataSource

interface PersistenceProvider {

    fun provideTokenLocalDataSource(): TokenLocalDataSource
}