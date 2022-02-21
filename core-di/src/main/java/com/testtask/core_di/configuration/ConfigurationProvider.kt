package com.testtask.core_di.configuration

import com.testtask.core_di.configuration.Configuration

interface ConfigurationProvider {

    fun provideConfiguration(): Configuration
}