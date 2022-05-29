package com.testtask.source

import com.testtask.Resource
import com.testtask.entity.DashBoardScreenEntity
import com.testtask.network.response.AnonymousUserResponse

interface DashBoardRemoteDataSource {

    suspend fun loadDashBoardScreens(): Resource<List<DashBoardScreenEntity>>
}