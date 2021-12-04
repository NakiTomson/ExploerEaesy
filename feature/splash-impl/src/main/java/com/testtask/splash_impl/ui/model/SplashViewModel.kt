package com.testtask.splash_impl.ui.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.testtask.base.BaseViewModel
import com.testtask.feature_core.AssistedSavedStateViewModelFactory
import com.testtask.interactors.SplashInteractor
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

class SplashViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    splashInteractor: SplashInteractor,
) : BaseViewModel() {


    val openDashBoard = splashInteractor.openDashBoardFlow.shareIn(
        viewModelScope, started = SharingStarted.Lazily, 1
    )


    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<SplashViewModel>

}