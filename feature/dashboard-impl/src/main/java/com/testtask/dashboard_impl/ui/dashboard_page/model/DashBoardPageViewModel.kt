package com.testtask.dashboard_impl.ui.dashboard_page.model

import androidx.lifecycle.SavedStateHandle
import com.testtask.base.BaseViewModel
import com.testtask.core_ui.utils.SingleLiveEventFlow
import com.testtask.dashboard_impl.ui.dashboard_page.event.DashBoardPageEvent
import com.testtask.utils.AssistedSavedStateViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class DashBoardPageViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle
) : BaseViewModel() {


    private val _event = SingleLiveEventFlow<DashBoardPageEvent>()
    override val event = _event.singleEvent


    init {

    }

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<DashBoardPageViewModel>
}