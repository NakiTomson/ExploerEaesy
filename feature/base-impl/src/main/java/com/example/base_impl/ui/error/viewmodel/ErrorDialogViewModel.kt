package com.example.base_impl.ui.error.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.example.base_impl.ui.error.event.ErrorEvent
import com.example.base_impl.ui.error.view.ErrorDialogFragment.Companion.ARG_ERROR_PARAMS
import com.example.params.ErrorDialogParams
import com.testtask.base.BaseViewModel
import com.testtask.core_ui.utils.SingleLiveEventFlow
import com.testtask.utils.AssistedSavedStateViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ErrorDialogViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val _event = SingleLiveEventFlow<ErrorEvent>()
    override val event = _event.singleEvent

    private val _paramsEmptyDialog: MutableStateFlow<ErrorDialogParams?> = MutableStateFlow(null)
    val paramsEmptyDialog: Flow<ErrorDialogParams?> = _paramsEmptyDialog.asStateFlow()

    private val params: ErrorDialogParams? = savedStateHandle.get(ARG_ERROR_PARAMS) as? ErrorDialogParams

    init {
        params?.let { _paramsEmptyDialog.value = it }
    }

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<ErrorDialogViewModel>
}