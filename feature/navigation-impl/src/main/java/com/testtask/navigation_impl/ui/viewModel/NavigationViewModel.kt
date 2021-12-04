package com.testtask.navigation_impl.ui.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.testtask.base.BaseViewModel
import com.testtask.feature_core.AssistedSavedStateViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class NavigationViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle
) : BaseViewModel() {


    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<NavigationViewModel>

}
