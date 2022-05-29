package com.testtask.persistence_impl.di

import com.testtask.core_di.ContextProvider
import com.testtask.core_di.NetworkProvider
import com.testtask.core_di.PersistenceProvider
import com.testtask.core_di.configuration.ConfigurationProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [ContextProvider::class, ConfigurationProvider::class],
    modules = [RoomModule::class, LocalDataSourceModule::class]
)
interface PersistenceComponent : PersistenceProvider {

    companion object {

        fun create(
            contextProvider: ContextProvider,
            configurationProvider: ConfigurationProvider
        ): PersistenceComponent {
            return DaggerPersistenceComponent.builder()
                .contextProvider(contextProvider)
                .configurationProvider(configurationProvider)
                .build()
        }
    }
}