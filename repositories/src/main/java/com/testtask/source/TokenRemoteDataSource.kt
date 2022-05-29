package com.testtask.source

import com.testtask.Resource
import com.testtask.network.response.AnonymousUserResponse

interface TokenRemoteDataSource {

    suspend fun loadUser(): Resource<AnonymousUserResponse>
}