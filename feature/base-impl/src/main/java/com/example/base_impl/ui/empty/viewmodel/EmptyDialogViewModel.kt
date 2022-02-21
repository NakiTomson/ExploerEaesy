package com.example.base_impl.ui.empty.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.example.base_impl.ui.empty.event.EmptyEvent
import com.example.base_impl.ui.empty.view.EmptyDialogFragment.Companion.ARG_EMPTY_PARAMS
import com.example.params.EmptyDialogParams
import com.testtask.base.BaseViewModel
import com.testtask.core_ui.utils.SingleLiveEventFlow
import com.testtask.utils.AssistedSavedStateViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.mapNotNull

class EmptyDialogViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val _event = SingleLiveEventFlow<EmptyEvent>()
    override val event = _event.singleEvent

    private val _paramsEmptyDialog: MutableStateFlow<EmptyDialogParams?> =
        MutableStateFlow(savedStateHandle.get(ARG_EMPTY_PARAMS) as? EmptyDialogParams)

    val paramsEmptyDialog: Flow<EmptyDialogParams> = _paramsEmptyDialog.asStateFlow().mapNotNull { it }


    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<EmptyDialogViewModel>
}