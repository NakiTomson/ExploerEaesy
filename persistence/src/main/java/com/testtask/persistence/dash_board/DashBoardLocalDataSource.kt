package com.testtask.persistence.dash_board

import com.testtask.Resource
import com.testtask.persistence.dash_board.dto.DashBoardScreenDb

interface DashBoardLocalDataSource {
    suspend fun createDashBoard(screen: DashBoardScreenDb)
    suspend fun createDashBoard(screen: List<DashBoardScreenDb>)
    suspend fun getDashBoards(): Resource<List<DashBoardScreenDb>>
}