package com.testtask.exploereaesy.di

import com.testtask.core_di.*
import com.testtask.core_di.dispatchers.DispatchersProvider
import com.testtask.exploereaesy.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        ContextProvider::class,
        RepositoryProvider::class,
        InteractorsProvider::class,
        NetworkProvider::class,
        PersistenceProvider::class,
        DispatchersProvider::class,
    ],
    modules = [
        FeatureApisModule::class
    ]
)
interface AppComponent : AppProvider {

    fun inject(activity: MainActivity)

    companion object {

        fun create(
            contextProvider: ContextProvider,
            networkProvider: NetworkProvider,
            repositoryProvider: RepositoryProvider,
            interactorsProvider: InteractorsProvider,
            persistenceProvider: PersistenceProvider,
            dispatchersProvider: DispatchersProvider,
        ): AppComponent {
            return DaggerAppComponent.builder()
                .contextProvider(contextProvider)
                .networkProvider(networkProvider)
                .repositoryProvider(repositoryProvider)
                .interactorsProvider(interactorsProvider)
                .persistenceProvider(persistenceProvider)
                .dispatchersProvider(dispatchersProvider)
                .build()
        }
    }
}