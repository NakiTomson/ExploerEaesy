package com.testtask.splash_impl.ui.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.testtask.base.BaseEvent
import com.testtask.base.BaseState
import com.testtask.base.BaseViewModel
import com.testtask.core_ui.utils.SingleLiveEventFlow
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


    private val _state = SingleLiveEventFlow<BaseState>()
    override val state = _state.singleEvent

    private val _event = SingleLiveEventFlow<BaseEvent>()
    override val event = _event.singleEvent

    val openDashBoard = splashInteractor.openDashBoardFlow.shareIn(
        viewModelScope, started = SharingStarted.Lazily, 1
    )


    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<SplashViewModel>

}