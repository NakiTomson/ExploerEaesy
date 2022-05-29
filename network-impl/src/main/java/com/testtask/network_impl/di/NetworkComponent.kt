package com.testtask.network_impl.di

import com.testtask.core_di.ContextProvider
import com.testtask.core_di.NetworkProvider
import com.testtask.core_di.PersistenceProvider
import com.testtask.core_di.configuration.ConfigurationProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        ContextProvider::class,
        ConfigurationProvider::class,
        PersistenceProvider::class
    ],
    modules = [NetworkModule::class, ApiModule::class]
)
interface NetworkComponent : NetworkProvider {


    companion object {

        fun create(
            contextProvider: ContextProvider,
            configurationProvider: ConfigurationProvider,
            persistenceProvider: PersistenceProvider,
        ): NetworkComponent {
            return DaggerNetworkComponent.builder()
                .contextProvider(contextProvider)
                .configurationProvider(configurationProvider)
                .persistenceProvider(persistenceProvider)
                .build()
        }
    }

}