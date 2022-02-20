package com.testtask.dashboard_impl.ui.dashboard.event

import com.testtask.base.BaseEvent

sealed interface DashBoardEvent : BaseEvent {

    class CloseDashBoard : DashBoardEvent

}