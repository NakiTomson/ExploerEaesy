package com.testtask.dashboard_impl.ui.dashboard.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.testtask.base.BaseViewModel
import com.testtask.core_ui.utils.SingleLiveEventFlow
import com.testtask.dashboard_impl.ui.dashboard.state.DashBoardEvent
import com.testtask.dashboard_impl.ui.dashboard.state.DashBoardEvent.CloseDashBoard
import com.testtask.dashboard_impl.ui.dashboard.state.DashBoardState.*
import com.testtask.ext.into
import com.testtask.ext.sendEvent
import com.testtask.feature_core.AssistedSavedStateViewModelFactory
import com.testtask.interactors.DashBoardInteractor
import com.testtask.network.errors.ServerError
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

class DashBoardViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val dashBoardInteractor: DashBoardInteractor,
) : BaseViewModel() {

//    override val state = DashBoardStateHandel(dashBoardInteractor, viewModelScope)

    val dashBoardScreens =
        dashBoardInteractor.dashBoardScreens.shareIn(viewModelScope, SharingStarted.Lazily, 1)

    private val _event = SingleLiveEventFlow<DashBoardEvent>()
    override val event = _event.singleEvent

    private val dashBoardPosition: Int
        get() = ((_state.value.subStates.firstOrNull { it is DashBoardPositionState }
            ?: DashBoardPositionState(0)) as DashBoardPositionState).position

    init {
        loadDashBoard()
        subscribeBoardScreens()
    }

    private fun loadDashBoard() {
        launch {
            dashBoardInteractor.loadDashBoardScreens()
        }
    }

    fun onNextClicked() {
        launch {
            if (selectedPagePosition < 2) {
                incrementPosition()
                return@launch
            }
            sendEvent(_closeDashBoard)
        }
    }

    fun onBackClicked() {
        if (selectedPagePosition > 0) {
            decrementPosition()
        }
    }

    private fun incrementPosition() {
        selectedPagePosition += 1
        into(_selectPage) { selectedPagePosition }
    }

    private fun decrementPosition() {
        selectedPagePosition -= 1
        into(_selectPage) { selectedPagePosition }
    }

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<DashBoardViewModel>
}