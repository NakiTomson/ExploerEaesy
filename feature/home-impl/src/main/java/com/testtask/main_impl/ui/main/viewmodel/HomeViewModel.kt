package com.testtask.main_impl.ui.main.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.testtask.base.BaseEvent
import com.testtask.base.BaseViewModel
import com.testtask.core_ui.utils.SingleLiveEventFlow
import com.testtask.utils.AssistedSavedStateViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


class HomeViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
) : BaseViewModel() {


    private val _event = SingleLiveEventFlow<BaseEvent>()
    override val event = _event.singleEvent

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<HomeViewModel>

}