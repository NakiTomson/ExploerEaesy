package com.example.base_impl.di

import com.example.base_impl.ui.empty.view.EmptyDialogFragment
import com.example.base_impl.ui.error.view.ErrorDialogFragment
import com.testtask.core_di.AppProvider
import dagger.Component

@Component(
    dependencies = [AppProvider::class],
    modules = [BaseFeatureViewModelFactoriesModule::class]
)
@FeatureBaseScope
interface FeatureBaseComponent {

    fun inject(fragment: ErrorDialogFragment)
    fun inject(fragment: EmptyDialogFragment)


    companion object {

        fun create(appProvider: AppProvider): FeatureBaseComponent {
            return DaggerFeatureBaseComponent.builder()
                .appProvider(appProvider)
                .build()
        }
    }
}