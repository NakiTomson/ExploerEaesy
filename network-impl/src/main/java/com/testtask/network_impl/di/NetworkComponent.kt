package com.testtask.network_impl.di

import com.testtask.core_di.ContextProvider
import com.testtask.core_di.NetworkProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        ContextProvider::class,
    ],
    modules = [NetworkModule::class, ApiModule::class]
)
interface NetworkComponent : NetworkProvider {


    companion object {

        fun create(
            contextProvider: ContextProvider,
        ): NetworkComponent {
            return DaggerNetworkComponent.builder()
                .contextProvider(contextProvider)
                .build()
        }
    }

}