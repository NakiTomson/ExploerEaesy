package com.testtask.exploereaesy.di

import com.testtask.core_di.dispatchers.DispatchersProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DispatchersModule::class])
interface DispatchersComponent : DispatchersProvider {

    companion object {

        fun create(): DispatchersComponent {
            return DaggerDispatchersComponent.builder()
                .build()
        }
    }
}