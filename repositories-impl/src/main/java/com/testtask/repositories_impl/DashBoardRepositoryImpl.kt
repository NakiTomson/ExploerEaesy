package com.testtask.repositories_impl


import com.testtask.Resource
import com.testtask.Resource.Status
import com.testtask.entity.DashBoardScreenEntity
import com.testtask.errors.ServerError
import com.testtask.network.service.DashBoardService
import com.testtask.network.сonverters.NetworkResult
import com.testtask.repositories.DashBoardRepository
import com.testtask.repositories_impl.mapper.toResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class DashBoardRepositoryImpl @Inject constructor(
    private val dashBoardService: DashBoardService
) : DashBoardRepository {

    private val _dashBoardScreens: MutableSharedFlow<Resource<List<DashBoardScreenEntity>>> =
        MutableStateFlow(Resource(Status.UNDEFINED, listOf()))

    override val dashBoardScreens: Flow<Resource<List<DashBoardScreenEntity>>> = _dashBoardScreens.asSharedFlow()

    override suspend fun loadDashBoardScreens() {
        _dashBoardScreens.emit(Resource(Status.LOADING, listOf()))
        when (val result = dashBoardService.getOnBoardingScreens()) {
            is NetworkResult.Response.Success -> {
                val response = result.data ?: throw  ServerError.UndefinedError()
                val resource = response.toResource()
                _dashBoardScreens.emit(resource)
            }
            is NetworkResult.Response.Error -> {
                _dashBoardScreens.emit(Resource(Status.ERROR, listOf(), ServerError.UndefinedError()))
            }
            is NetworkResult.Exception -> {
                _dashBoardScreens.emit(Resource(Status.ERROR, listOf(), ServerError.UndefinedError()))
            }
        }
    }
}