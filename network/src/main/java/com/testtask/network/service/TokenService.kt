package com.testtask.network.service

import com.testtask.network.response.AnonymousUserResponse
import com.testtask.network.сonverters.NetworkResult
import retrofit2.http.GET

interface TokenService {

    @GET("api/v1/anonymousUser")
    suspend fun getAnonymousUser(): NetworkResult<AnonymousUserResponse>
}