package com.testtask.interactors_impl.di

import com.testtask.core_di.InteractorsProvider
import com.testtask.core_di.RepositoryProvider
import dagger.Component

@Component(dependencies = [RepositoryProvider::class], modules = [InteractorsModule::class])
interface InteractorsComponent : InteractorsProvider {


    companion object {

        fun create(repositoryProvider: RepositoryProvider): InteractorsComponent {
            return DaggerInteractorsComponent.builder()
                .repositoryProvider(repositoryProvider)
                .build()
        }
    }
}