package com.testtask.interactors_impl.di

import com.testtask.core_di.InteractorsProvider
import com.testtask.core_di.RepositoryProvider
import com.testtask.core_di.dispatchers.DispatchersProvider
import dagger.Component

@Component(dependencies = [RepositoryProvider::class, DispatchersProvider::class], modules = [InteractorsModule::class])
interface InteractorsComponent : InteractorsProvider {


    companion object {

        fun create(
            repositoryProvider: RepositoryProvider,
            dispatchersProvider: DispatchersProvider
        ): InteractorsComponent {
            return DaggerInteractorsComponent.builder()
                .repositoryProvider(repositoryProvider)
                .dispatchersProvider(dispatchersProvider)
                .build()
        }
    }
}