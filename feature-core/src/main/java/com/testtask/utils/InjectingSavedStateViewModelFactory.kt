package com.testtask.utils

import android.os.Bundle
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner
import dagger.Reusable
import javax.inject.Inject


@Reusable
class InjectingSavedStateViewModelFactory @Inject constructor(
    private val assistedFactories: Map<Class<out ViewModel>, AssistedFactory>
) {
    fun create(owner: SavedStateRegistryOwner, defaultArgs: Bundle? = null): AbstractSavedStateViewModelFactory {
        return object : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
                assistedFactories[modelClass]?.let {
                    try {
                        return it.create(handle) as T
                    } catch (e: Exception) {
                        throw RuntimeException(e)
                    }
                } ?: throw IllegalArgumentException("Unknown model class $modelClass")
            }
        }
    }
}


typealias AssistedFactory = @JvmSuppressWildcards AssistedSavedStateViewModelFactory<out ViewModel>

