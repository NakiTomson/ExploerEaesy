package com.testtask.dashboard_impl.ui.dashboard.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.testtask.base.BaseViewModel
import com.testtask.core_ui.utils.SingleLiveEventFlow
import com.testtask.dashboard_impl.ui.dashboard.state.DashBoardEvent
import com.testtask.dashboard_impl.ui.dashboard.state.DashBoardEvent.CloseDashBoard
import com.testtask.entity.DashBoardScreenEntity
import com.testtask.entity.Resource.Status.*
import com.testtask.base_ext.sendEvent
import com.testtask.utils.AssistedSavedStateViewModelFactory
import com.testtask.interactors.DashBoardInteractor
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.*

class DashBoardViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val dashBoardInteractor: DashBoardInteractor,
) : BaseViewModel() {

    private val _event = SingleLiveEventFlow<DashBoardEvent>()
    override val event = _event.singleEvent

    private val _showLoading = MutableStateFlow(false)
    val showLoading: Flow<Boolean> = _showLoading.asStateFlow()

    private val _showError = MutableStateFlow(false)
    val showError: Flow<Boolean> = _showError.asStateFlow()

    private val _showEmpty = MutableStateFlow(false)
    val showEmpty: Flow<Boolean> = _showEmpty.asStateFlow()

    private val _screenPosition = MutableStateFlow(0)
    val screenPosition: Flow<Int> = _screenPosition.asStateFlow()

    private val _showDashBoards: MutableStateFlow<List<DashBoardScreenEntity>> = MutableStateFlow(listOf())
    val showDashBoards: Flow<List<DashBoardScreenEntity>> = _showDashBoards.asStateFlow().filter { it.isNotEmpty() }

    val showDashBoardNavigation: Flow<Boolean> = _showDashBoards.map { it.isNotEmpty() }

    private val dashBoardPosition: Int = 0

    init {
        loadDashBoard()
        subscribeBoardScreens()
    }

    private fun loadDashBoard() {
        viewModelScope.launch {
            dashBoardInteractor.loadDashBoardScreens()
        }
    }

    private fun subscribeBoardScreens() {
        viewModelScope.launch {
            dashBoardInteractor.dashBoardScreens.collect {
//                if (it.status == COMPLETED) _showDashBoards.emit(it.data)
                _showLoading.emit(it.status == LOADING)
                _showError.emit(it.status == ERROR)
                _showEmpty.emit(it.status == EMPTY)
            }
        }
    }

    private fun incrementPosition() {
        viewModelScope.launch {

        }
    }

    private fun decrementPosition() {
        viewModelScope.launch {

        }
    }

    fun onButtonNextClicked() {
        viewModelScope.launch {
            if (dashBoardPosition < 2) {
                incrementPosition()
                return@launch
            }
            sendEvent(_event) { CloseDashBoard() }
        }
    }

    fun onButtonBackClicked() {
        if (dashBoardPosition > 0) {
            decrementPosition()
        }
    }

    fun onLoadTryAgain() {
        loadDashBoard()
    }

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<DashBoardViewModel>
}