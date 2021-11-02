package com.testtask.persistence_impl.di

import com.testtask.core_di.ContextProvider
import com.testtask.core_di.PersistenceProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [ContextProvider::class], modules = [RoomModule::class])
interface PersistenceComponent : PersistenceProvider {

    companion object {

        fun create(contextProvider: ContextProvider): PersistenceComponent {
            return DaggerPersistenceComponent.builder()
                .contextProvider(contextProvider)
                .build()
        }
    }
}