package com.testtask.persistence_impl.dashboard.local

import com.testtask.Resource
import com.testtask.persistence.dao.DashBoardDao
import com.testtask.persistence.dash_board.DashBoardLocalDataSource
import com.testtask.persistence.dash_board.dto.DashBoardScreenDb
import javax.inject.Inject

class RoomDashBoardDataSource @Inject constructor(
    private val dashBoardDao: DashBoardDao,
) : DashBoardLocalDataSource {

    override fun createDashBoard(screen: DashBoardScreenDb) {
        dashBoardDao.insert(screen)
    }

    override fun createDashBoard(screen: List<DashBoardScreenDb>) {
       screen.forEach { createDashBoard(it) }
    }

    override fun getDashBoards(): Resource<List<DashBoardScreenDb>> {
        val result = dashBoardDao.getAll() ?: listOf()
        val status = if (result.isNullOrEmpty()) Resource.Status.EMPTY else Resource.Status.COMPLETED
        return Resource(status, result)
    }
}