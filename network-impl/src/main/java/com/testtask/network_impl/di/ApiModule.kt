package com.testtask.network_impl.di

import com.testtask.network.service.DashBoardService
import com.testtask.network.service.ServiceFactory
import com.testtask.network.service.TokenService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {


    @Provides
    @Singleton
    fun provideDashBoardService(serviceFactory: ServiceFactory): DashBoardService {
        return serviceFactory.createService(DashBoardService::class.java)
    }

    @Provides
    @Singleton
    fun provideTokenService(serviceFactory: ServiceFactory): TokenService {
        return serviceFactory.createService(TokenService::class.java)
    }
}