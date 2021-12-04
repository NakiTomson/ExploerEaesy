package com.testtask.main_impl.ui.main.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.testtask.base.BaseViewModel
import com.testtask.feature_core.AssistedSavedStateViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


class HomeViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
) : BaseViewModel() {


    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<HomeViewModel>

}