package com.testtask.repositories

import com.testtask.entity.BoardScreenEntity
import kotlinx.coroutines.flow.Flow

interface DashBoardRepository {

    val dashBoardScreens: Flow<List<BoardScreenEntity>>

    suspend fun loadDashBoardScreens()
}