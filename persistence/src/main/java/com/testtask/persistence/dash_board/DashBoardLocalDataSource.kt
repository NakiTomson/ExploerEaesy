package com.testtask.persistence.dash_board

import com.testtask.Resource
import com.testtask.persistence.dash_board.dto.DashBoardScreenDb

interface DashBoardLocalDataSource {
    fun createDashBoard(screen: DashBoardScreenDb)
    fun createDashBoard(screen: List<DashBoardScreenDb>)
    fun getDashBoards(): Resource<List<DashBoardScreenDb>>
}