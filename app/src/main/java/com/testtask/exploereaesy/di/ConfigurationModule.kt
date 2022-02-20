package com.testtask.exploereaesy.di

import com.testtask.core_di.configuration.Configuration
import com.testtask.exploereaesy.ConfigurationImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ConfigurationModule {

    @Singleton
    @Binds
    fun bindsConfiguration(impl: ConfigurationImpl): Configuration
}