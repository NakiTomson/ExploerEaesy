package com.testtask.navigation_impl.ui.viewModel

import androidx.lifecycle.SavedStateHandle
import com.testtask.base.BaseEvent
import com.testtask.base.BaseViewModel
import com.testtask.core_ui.utils.SingleLiveEventFlow
import com.testtask.utils.AssistedSavedStateViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class NavigationViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle
) : BaseViewModel() {


    private val _event = SingleLiveEventFlow<BaseEvent>()
    override val event = _event.singleEvent


    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<NavigationViewModel>

}
