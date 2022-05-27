package com.testtask.persistence_impl.di

import com.testtask.core_di.ContextProvider
import com.testtask.core_di.NetworkProvider
import com.testtask.core_di.PersistenceProvider
import com.testtask.core_di.configuration.ConfigurationProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [ContextProvider::class, ConfigurationProvider::class, NetworkProvider::class],
    modules = [RoomModule::class, DataSourceModule::class]
)
interface PersistenceComponent : PersistenceProvider {

    companion object {

        fun create(
            contextProvider: ContextProvider,
            configurationProvider: ConfigurationProvider,
            networkProvider: NetworkProvider
        ): PersistenceComponent {
            return DaggerPersistenceComponent.builder()
                .contextProvider(contextProvider)
                .configurationProvider(configurationProvider)
                .networkProvider(networkProvider)
                .build()
        }
    }
}