package com.testtask.repositories


import com.testtask.entity.DashBoardScreenEntity
import com.testtask.entity.Resource
import kotlinx.coroutines.flow.Flow

interface DashBoardRepository {

    val dashBoardScreens: Flow<Resource<List<DashBoardScreenEntity>>>

    suspend fun loadDashBoardScreens()
}