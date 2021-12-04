package com.testtask.exploereaesy.di

import android.app.Application
import com.testtask.core_di.*
import com.testtask.exploereaesy.view.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        ContextProvider::class,
        RepositoryProvider::class,
        InteractorsProvider::class,
        NetworkProvider::class,
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
        ): AppComponent {
            return DaggerAppComponent.builder()
                .contextProvider(contextProvider)
                .networkProvider(networkProvider)
                .repositoryProvider(repositoryProvider)
                .interactorsProvider(interactorsProvider)
                .build()
        }
    }
}