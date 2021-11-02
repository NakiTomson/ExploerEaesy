package com.example.user.ui.user.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.testtask.feature_core.AssistedSavedStateViewModelFactory

class UserViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
) : ViewModel(
) {


    @AssistedInject.Factory
    interface Factory : AssistedSavedStateViewModelFactory<UserViewModel> {
        override fun create(savedStateHandle: SavedStateHandle): UserViewModel
    }
}