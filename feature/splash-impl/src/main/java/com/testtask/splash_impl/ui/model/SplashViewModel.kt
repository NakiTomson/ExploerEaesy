package com.testtask.splash_impl.ui.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.testtask.feature_core.AssistedSavedStateViewModelFactory
import com.testtask.interactors.SplashInteractor
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn

class SplashViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    splashInteractor: SplashInteractor,
) : ViewModel() {

//    val _openDashBoard2 =
//        MutableSharedFlow<Boolean>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
//    val openDashBoard2 = _openDashBoard2.asSharedFlow()

    val openDashBoard = splashInteractor.openDashBoardFlow.shareIn(
        viewModelScope, started = SharingStarted.Lazily, 1)

    @AssistedInject.Factory
    interface Factory : AssistedSavedStateViewModelFactory<SplashViewModel> {
        override fun create(savedStateHandle: SavedStateHandle): SplashViewModel
    }
}