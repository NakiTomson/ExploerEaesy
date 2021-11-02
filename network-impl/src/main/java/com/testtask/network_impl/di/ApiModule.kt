package com.testtask.network_impl.di

import com.testtask.network.service.DashBoardService
import com.testtask.network.service.ServiceFactory
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
}