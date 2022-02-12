package com.testtask.repositories_impl

import com.testtask.entity.BoardScreenEntity
import com.testtask.network.errors.ServerError
import com.testtask.network.service.DashBoardService
import com.testtask.network.сonverters.NetworkResult
import com.testtask.repositories.DashBoardRepository
import com.testtask.repositories_impl.mapper.toDashBoardScreensEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class DashBoardRepositoryImpl @Inject constructor(
    private val dashBoardService: DashBoardService
) : DashBoardRepository {

    private val _dashBoardScreens: MutableSharedFlow<List<BoardScreenEntity>> = MutableSharedFlow()
    override val dashBoardScreens: Flow<List<BoardScreenEntity>> = _dashBoardScreens.asSharedFlow()

    override suspend fun loadDashBoardScreens() {
        when (val result = dashBoardService.getOnBoardingScreens()) {
            is NetworkResult.Response.Success -> {
                val response = result.data ?: throw  ServerError.UndefinedError()
                _dashBoardScreens.emit(response.toDashBoardScreensEntity())
            }
            is NetworkResult.Response.Error -> throw ServerError.UndefinedError()
            is NetworkResult.Exception -> throw ServerError.UndefinedError()
        }
    }
}