package com.testtask.repositories_impl.di

import com.testtask.core_di.ContextProvider
import com.testtask.core_di.NetworkProvider
import com.testtask.core_di.PersistenceProvider
import com.testtask.core_di.RepositoryProvider
import dagger.Component

@Component(
    dependencies = [NetworkProvider::class, ContextProvider::class, PersistenceProvider::class],
    modules = [RepositoriesModule::class, RemoteSourceModule::class]
)
interface RepositoriesComponent : RepositoryProvider {

    companion object {

        fun create(
            networkProvider: NetworkProvider,
            contextProvider: ContextProvider,
            persistenceProvider: PersistenceProvider,
        ): RepositoriesComponent {
            return DaggerRepositoriesComponent.builder()
                .networkProvider(networkProvider)
                .contextProvider(contextProvider)
                .persistenceProvider(persistenceProvider)
                .build()
        }
    }
}