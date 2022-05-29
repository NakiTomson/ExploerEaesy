package com.testtask.exploereaesy.di

import com.testtask.core_di.dispatchers.Dispatchers
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

@Module
object DispatchersModule {
    @Provides
    fun provideDispatchers(): Dispatchers {
        return object : Dispatchers {
            override val io: CoroutineDispatcher = kotlinx.coroutines.Dispatchers.IO
            override val main: CoroutineDispatcher = kotlinx.coroutines.Dispatchers.Main
            override val compute: CoroutineDispatcher = kotlinx.coroutines.Dispatchers.Default
        }
    }
}