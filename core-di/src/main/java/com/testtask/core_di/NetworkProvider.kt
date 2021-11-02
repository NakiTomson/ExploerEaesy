package com.testtask.core_di

import com.testtask.network.service.DashBoardService
import com.testtask.network.service.ServiceFactory
import okhttp3.Dispatcher
import okhttp3.Interceptor

interface NetworkProvider {

    fun provideDashBoardService(): DashBoardService

}