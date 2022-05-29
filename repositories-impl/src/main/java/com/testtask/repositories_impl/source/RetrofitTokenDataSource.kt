package com.testtask.repositories_impl.source

import com.testtask.Resource
import com.testtask.errors.ServerError
import com.testtask.network.response.AnonymousUserResponse
import com.testtask.network.service.TokenService
import com.testtask.network.сonverters.NetworkResult
import com.testtask.persistence.anonymous_user.mapper.toResource
import com.testtask.source.TokenRemoteDataSource
import javax.inject.Inject

class RetrofitTokenDataSource @Inject constructor(
    private val tokenService: TokenService
) : TokenRemoteDataSource {

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
