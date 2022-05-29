package com.testtask.repositories_impl.dashboard.source

import com.testtask.Resource
import com.testtask.entity.DashBoardScreenEntity
import com.testtask.errors.ServerError
import com.testtask.network.service.DashBoardService
import com.testtask.network.сonverters.NetworkResult
import com.testtask.repositories_impl.dashboard.mapper.toResource
import com.testtask.source.DashBoardRemoteDataSource
import javax.inject.Inject

class DashBoardRetrofitDataSource @Inject constructor(
    private val dashBoardService: DashBoardService
) : DashBoardRemoteDataSource {

    override suspend fun loadDashBoardScreens(): Resource<List<DashBoardScreenEntity>> {
        return when (val result = dashBoardService.getOnBoardingScreens()) {
            is NetworkResult.Response.Success -> {
                val response = result.data ?: throw  ServerError.UndefinedError()
                response.toResource()
            }
            is NetworkResult.Response.Error -> {
                Resource(Resource.Status.ERROR, listOf(), ServerError.UndefinedError())
            }
            is NetworkResult.Exception -> {
                Resource(Resource.Status.ERROR, listOf(), ServerError.UndefinedError())
            }
        }
    }
}