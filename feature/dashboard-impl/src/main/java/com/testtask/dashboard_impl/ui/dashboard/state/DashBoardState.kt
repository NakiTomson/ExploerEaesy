package com.testtask.dashboard_impl.ui.dashboard.state

import com.testtask.base.BaseEvent
import com.testtask.base.BaseState
import com.testtask.interactors.DashBoardInteractor
import kotlinx.coroutines.CoroutineScope

open class DashBoardState(dashBoardInteractor: DashBoardInteractor, viewModelScope: CoroutineScope) : BaseState, BaseEvent {


}
