package com.example.user.ui.user.model

import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateHandle
import com.example.user.di.AnalitiksTracker
import com.example.user.di.Analytics
import com.example.user.di.UserComponent
import com.testtask.base.BaseEvent
import com.testtask.base.BaseViewModel
import com.testtask.core_ui.utils.SingleLiveEventFlow
import com.testtask.utils.AssistedSavedStateViewModelFactory
import com.testtask.utils.appComponent
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class UserViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    analytics: Analytics,
) : BaseViewModel() {

    private val _event = SingleLiveEventFlow<BaseEvent>()
    override val event = _event.singleEvent

    init {
        analytics.trackLogEvent(AnalitiksTracker.Event("Init", "UserViewModel"))
    }

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<UserViewModel>

    companion object {

        val Fragment.injector: UserComponent
            get() {
                return UserComponent.create(requireContext().appComponent)
            }
    }
}


