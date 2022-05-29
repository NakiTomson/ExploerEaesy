package com.testtask.splash_impl.ui.model

import androidx.lifecycle.SavedStateHandle
import com.testtask.base.BaseEvent
import com.testtask.base.BaseViewModel
import com.testtask.core_ui.utils.SingleLiveEventFlow
import com.testtask.interactors.TokenInteractor
import com.testtask.utils.AssistedSavedStateViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class SplashViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private val tokenInteractor: TokenInteractor,
) : BaseViewModel() {

    private val _event = SingleLiveEventFlow<BaseEvent>()
    override val event = _event.singleEvent

    val openDashBoard = flow {
        tokenInteractor.createAnonymousSession()
        delay(TIME_DELAY)
        emit(Unit)
    }


    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<SplashViewModel>

    companion object {
        const val TIME_DELAY = 1000L
    }
}
