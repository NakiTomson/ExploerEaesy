package com.testtask.dashboard_impl.ui.dashboard.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testtask.base.BaseViewModel
import com.testtask.feature_core.AssistedSavedStateViewModelFactory
import com.testtask.interactors.DashBoardInteractor
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

class DashBoardViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val dashBoardInteractor: DashBoardInteractor,
) : BaseViewModel() {

    val dashBoardScreens = dashBoardInteractor.dashBoardScreens.shareIn(
        viewModelScope, started = SharingStarted.Lazily, 1
    )

    private val _selectPageFlow = MutableStateFlow(0)
    val selectPage = _selectPageFlow.asStateFlow()

    private val _closeDashBoardFlow = MutableStateFlow(false)
    val closeDashBoard = _closeDashBoardFlow.asStateFlow()

    private var selectedPagePosition = 0

    fun onNextClicked() {
        launch {
            if (selectedPagePosition < 2) {
                incrementPosition()
                return@launch
            }
            _closeDashBoardFlow.emit(true)
        }
    }

    fun onBackClicked() {
        if (selectedPagePosition > 0) {
            decrementPosition()
        }
    }

    private fun incrementPosition() {
        selectedPagePosition += 1
        _selectPageFlow.value = selectedPagePosition
    }

    private fun decrementPosition() {
        selectedPagePosition -= 1
        _selectPageFlow.value = selectedPagePosition
    }

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<DashBoardViewModel>
}