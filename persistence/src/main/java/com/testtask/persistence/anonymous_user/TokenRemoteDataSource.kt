package com.testtask.persistence.anonymous_user

import com.testtask.Resource
import com.testtask.network.response.AnonymousUserResponse
import kotlinx.coroutines.flow.Flow

interface TokenRemoteDataSource {

    suspend fun loadUser(): Resource<AnonymousUserResponse>
}