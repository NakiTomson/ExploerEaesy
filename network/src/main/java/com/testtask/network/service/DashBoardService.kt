package com.testtask.network.service


import com.testtask.network.response.DashBoardScreenResponse
import com.testtask.network.сonverters.NetworkResult
import retrofit2.http.GET

interface DashBoardService {

    /**
     * Получить данные для экранов онбординга
     */
    @GET("api/v1/screens")
    suspend fun getOnBoardingScreens(): NetworkResult<List<DashBoardScreenResponse>>
}