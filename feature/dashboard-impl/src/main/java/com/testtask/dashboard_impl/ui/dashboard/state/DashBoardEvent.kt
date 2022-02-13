package com.testtask.dashboard_impl.ui.dashboard.state

import com.testtask.base.BaseEvent

sealed interface DashBoardEvent : BaseEvent {

    class CloseDashBoard : DashBoardEvent

}