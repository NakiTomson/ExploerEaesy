package com.testtask.exploereaesy.di

import com.testtask.core_di.AppProvider
import com.testtask.core_di.ContextProvider
import com.testtask.exploereaesy.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        ContextProvider::class,
    ],
    modules = [
        FeatureApisModule::class
    ]
)
interface AppComponent : AppProvider {

    fun inject(activity: MainActivity)

    companion object {

        fun create(
            contextProvider: ContextProvider
        ): AppComponent {
            return DaggerAppComponent.builder()
                .contextProvider(contextProvider)
                .build()
        }
    }
}