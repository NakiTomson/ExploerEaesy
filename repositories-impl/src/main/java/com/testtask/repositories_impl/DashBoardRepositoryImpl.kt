package com.testtask.repositories_impl

import com.testtask.entity.BoardScreenEntity
import com.testtask.network.errors.ServerError
import com.testtask.network.service.DashBoardService
import com.testtask.network.сonverters.NetworkResult
import com.testtask.repositories.DashBoardRepository
import com.testtask.repositories_impl.mapper.toDashBoardScreensEntity
import javax.inject.Inject

class DashBoardRepositoryImpl @Inject constructor(
    private val dashBoardService: DashBoardService
) : DashBoardRepository {

    override suspend fun loadDashBoardScreens(): List<BoardScreenEntity> {
        return when (val result = dashBoardService.getOnBoardingScreens()) {
            is NetworkResult.Response.Success -> {
                val response = result.data ?: throw  ServerError.UndefinedError()
                response.toDashBoardScreensEntity()
            }
            is NetworkResult.Response.Error -> throw ServerError.UndefinedError()
            is NetworkResult.Exception -> throw ServerError.UndefinedError()
        }
    }
}