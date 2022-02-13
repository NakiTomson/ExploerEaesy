package com.testtask.main_impl.ui.main.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.testtask.base.BaseEvent
import com.testtask.base.BaseState
import com.testtask.base.BaseViewModel
import com.testtask.core_ui.utils.SingleLiveEventFlow
import com.testtask.feature_core.AssistedSavedStateViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


class HomeViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
) : BaseViewModel() {


    private val _state = SingleLiveEventFlow<BaseState>()
    override val state = _state.singleEvent

    private val _event = SingleLiveEventFlow<BaseEvent>()
    override val event = _event.singleEvent

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<HomeViewModel>

}