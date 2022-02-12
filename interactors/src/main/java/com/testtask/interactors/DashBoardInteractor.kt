package com.testtask.interactors

import com.testtask.entity.BoardScreenEntity
import kotlinx.coroutines.flow.Flow

interface DashBoardInteractor {

    val dashBoardScreens: Flow<List<BoardScreenEntity>>

    suspend fun loadDashBoardScreens()
}
