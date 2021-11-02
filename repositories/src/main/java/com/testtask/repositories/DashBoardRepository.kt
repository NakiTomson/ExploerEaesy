package com.testtask.repositories

import com.testtask.entity.BoardScreenEntity

interface DashBoardRepository {

    suspend fun loadDashBoardScreens(): List<BoardScreenEntity>
}