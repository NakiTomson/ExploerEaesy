package com.testtask.splash_impl.ui.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.testtask.base.BaseEvent
import com.testtask.base.BaseViewModel
import com.testtask.core_ui.utils.SingleLiveEventFlow
import com.testtask.utils.AssistedSavedStateViewModelFactory
import com.testtask.interactors.SplashInteractor
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class SplashViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    splashInteractor: SplashInteractor,
) : BaseViewModel() {

    private val _event = SingleLiveEventFlow<BaseEvent>()
    override val event = _event.singleEvent

    val openDashBoard = flow {
        delay(2000)
        emit(Unit)
    }


    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<SplashViewModel>

}