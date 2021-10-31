package com.testtask.navigation_impl.ui.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.testtask.feature_core.AssistedSavedStateViewModelFactory

class NavigationViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle
) : ViewModel() {

    @AssistedInject.Factory
    interface Factory : AssistedSavedStateViewModelFactory<NavigationViewModel> {
        override fun create(savedStateHandle: SavedStateHandle): NavigationViewModel
    }
}
