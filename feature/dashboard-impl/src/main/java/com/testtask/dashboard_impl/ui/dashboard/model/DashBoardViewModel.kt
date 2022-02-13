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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DashBoardViewModel @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val dashBoardInteractor: DashBoardInteractor,
) : BaseViewModel() {

    private val _state = MutableStateFlow(RenderFullState())
    override val state = _state.asStateFlow()

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
        viewModelScope.launch {
            try {
                into(_state) { RenderFullState(loadingState = DashBoardLoadingState(true)) }
                dashBoardInteractor.loadDashBoardScreens()
            } catch (e: ServerError) {
                into(_state) {
                    RenderFullState(errorState = DashBoardErrorState(true))
                }
            }
        }
    }

    private fun subscribeBoardScreens() {
        viewModelScope.launch {
            dashBoardInteractor.dashBoardScreens.collect {
                into(_state) {
                    RenderFullState(
                        dashBoardLoadedState = DashBoardLoadedState(it),
                        emptyState = DashBoardEmptyState(it.isEmpty())
                    )
                }
            }
        }
    }

    fun onNextClicked() {
        launch {
            if (dashBoardPosition < 2) {
                incrementPosition()
                return@launch
            }
            sendEvent(_event) { CloseDashBoard() }
        }
    }

    fun onBackClicked() {
        if (dashBoardPosition > 0) {
            decrementPosition()
        }
    }

    private fun incrementPosition() {
        launch {
            into(_state) { RenderIndividuallyState(DashBoardPositionState(dashBoardPosition + 1)) }
        }
    }

    private fun decrementPosition() {
        launch {
            into(_state) { RenderIndividuallyState(DashBoardPositionState(dashBoardPosition - 1)) }
        }
    }

    @AssistedFactory
    interface Factory : AssistedSavedStateViewModelFactory<DashBoardViewModel>
}