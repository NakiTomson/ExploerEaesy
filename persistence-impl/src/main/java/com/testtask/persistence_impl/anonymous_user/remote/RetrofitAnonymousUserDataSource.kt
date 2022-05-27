package com.testtask.persistence_impl.anonymous_user.remote

import com.testtask.Resource
import com.testtask.errors.ServerError
import com.testtask.network.response.AnonymousUserResponse
import com.testtask.network.service.TokenService
import com.testtask.network.сonverters.NetworkResult
import com.testtask.persistence.anonymous_user.AnonymousUserRemoteDataSource
import com.testtask.persistence.anonymous_user.mapper.toResource
import javax.inject.Inject

class RetrofitAnonymousUserDataSource @Inject constructor(
    private val tokenService: TokenService
) : AnonymousUserRemoteDataSource {

    override suspend fun loadUser(): Resource<AnonymousUserResponse> {
        return when (val result = tokenService.getAnonymousUser()) {
            is NetworkResult.Response.Success -> {
                val response = result.data ?: throw  ServerError.UndefinedError()
                response.toResource()
            }
            is NetworkResult.Response.Error -> {
                Resource(Resource.Status.ERROR, AnonymousUserResponse(null), ServerError.UndefinedError())
            }
            is NetworkResult.Exception -> {
                Resource(Resource.Status.ERROR, AnonymousUserResponse(null), ServerError.UndefinedError())
            }
        }
    }
}
