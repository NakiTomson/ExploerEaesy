package com.testtask.exploereaesy.di

import com.testtask.core_di.ContextProvider
import com.testtask.core_di.configuration.ConfigurationProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [ContextProvider::class],
    modules = [ConfigurationModule::class]
)
interface ConfigurationComponent : ConfigurationProvider {

    companion object {

        fun create(contextProvider: ContextProvider): ConfigurationComponent {
            return DaggerConfigurationComponent.builder()
                .contextProvider(contextProvider)
                .build()
        }
    }
}