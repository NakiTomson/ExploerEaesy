package com.testtask.dashboard_impl.ui.dashboard.state

import com.testtask.dashboard_impl.ui.dashboard.model.DashBoardViewModel
import com.testtask.ext.sendEvent
import com.testtask.interactors.DashBoardInteractor
import kotlinx.coroutines.CoroutineScope

class DashBoardStateHandel(dashBoardInteractor: DashBoardInteractor, viewModelScope: CoroutineScope) :
    DashBoardState(dashBoardInteractor, viewModelScope), DashBoardEvent {

    override fun closeDashBoard() {

    }
}