package com.testtask.repositories_impl

import com.testtask.entity.AnonymousUserEntity
import com.testtask.persistence.anonymous_user.TokenLocalDataSource
import com.testtask.persistence.anonymous_user.mapper.toUserBb
import com.testtask.persistence.anonymous_user.mapper.toUserEntity
import com.testtask.repositories.TokenRepository
import com.testtask.source.TokenRemoteDataSource
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val localSource: TokenLocalDataSource,
    private val remoteSource: TokenRemoteDataSource,
) : TokenRepository {

    override suspend fun createAnonymousUser() {
        val resource = remoteSource.loadUser()
        resource.data.anonymousToken ?: return
        val user = resource.data
            .toUserEntity(localSource.getUser()?.isOnBoarded == true)
            .toUserBb(System.currentTimeMillis())
        localSource.createUser(user)
    }

    override suspend fun updateAnonymousUser(anonymousUserEntity: AnonymousUserEntity) {
        localSource.updateUser(anonymousUserEntity.toUserBb(System.currentTimeMillis()))
    }

    override suspend fun getAnonymousUserOrNull(): AnonymousUserEntity? {
        return localSource.getUser()?.toUserEntity()
    }
}