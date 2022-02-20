package com.testtask.interactors


import com.testtask.entity.DashBoardScreenEntity
import com.testtask.entity.Resource
import kotlinx.coroutines.flow.Flow

interface DashBoardInteractor {

    val dashBoardScreens: Flow<Resource<List<DashBoardScreenEntity>>>

    suspend fun loadDashBoardScreens()
}
