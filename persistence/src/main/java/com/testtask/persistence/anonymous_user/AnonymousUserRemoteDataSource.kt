package com.testtask.persistence.anonymous_user

import com.testtask.Resource
import com.testtask.network.response.AnonymousUserResponse
import kotlinx.coroutines.flow.Flow

interface AnonymousUserRemoteDataSource {

    suspend fun loadUser(): Resource<AnonymousUserResponse>
}