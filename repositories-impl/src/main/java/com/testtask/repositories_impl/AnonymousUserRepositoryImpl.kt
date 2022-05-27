package com.testtask.repositories_impl

import com.testtask.entity.AnonymousUserEntity
import com.testtask.persistence.anonymous_user.AnonymousUserLocalDataSource
import com.testtask.persistence.anonymous_user.AnonymousUserRemoteDataSource
import com.testtask.persistence.anonymous_user.mapper.toUserBb
import com.testtask.persistence.anonymous_user.mapper.toUserEntity
import com.testtask.repositories.AnonymousUserRepository
import javax.inject.Inject

class AnonymousUserRepositoryImpl @Inject constructor(
    private val localSource: AnonymousUserLocalDataSource,
    private val remoteSource: AnonymousUserRemoteDataSource,
) : AnonymousUserRepository {

    override suspend fun createAnonymousUser() {
        val user = remoteSource.loadUser()
        user.data.anonymousToken ?: return
        localSource.createUser(user.data.toUserEntity(localSource.getUser()?.isOnBoarded == true).toUserBb())
    }

    override suspend fun updateAnonymousUser(anonymousUserEntity: AnonymousUserEntity) {
        localSource.updateUser(anonymousUserEntity.toUserBb())
    }
}