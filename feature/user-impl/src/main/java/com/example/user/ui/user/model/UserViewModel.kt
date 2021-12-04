package com.example.user.ui.user.model

import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.user.di.AnalitiksTracker
import com.example.user.di.Analytics
import com.example.user.di.UserComponent
import com.testtask.base.BaseViewModel
import com.testtask.feature_core.AssistedSavedStateViewModelFactory
import com.testtask.feature_core.appComponent
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class UserViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    analytics: Analytics,
) : BaseViewModel() {

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


