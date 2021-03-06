package com.testtask.exploereaesy.di

import android.content.Context
import com.testtask.core_di.ContextProvider
import dagger.BindsInstance
import dagger.Component
import dagger.Reusable

@Component
interface ContextComponent : ContextProvider {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(@Reusable context: Context): Builder

        fun build(): ContextComponent
    }

    companion object {
        fun create(context: Context): ContextComponent {
            return DaggerContextComponent.builder()
                .context(context)
                .build()
        }
    }
}