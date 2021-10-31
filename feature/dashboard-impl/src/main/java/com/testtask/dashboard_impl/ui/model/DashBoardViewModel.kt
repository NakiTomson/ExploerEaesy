package com.testtask.dashboard_impl.ui.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.testtask.feature_core.AssistedSavedStateViewModelFactory

class DashBoardViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
): ViewModel() {



    @AssistedInject.Factory
    interface Factory : AssistedSavedStateViewModelFactory<DashBoardViewModel> {
        override fun create(savedStateHandle: SavedStateHandle): DashBoardViewModel
    }
}