package com.testtask.persistence_impl.anonymous_user.local

import com.testtask.persistence.anonymous_user.TokenLocalDataSource
import com.testtask.persistence.anonymous_user.dto.AnonymousUserDb
import com.testtask.persistence.dao.AnonymousUserDao
import javax.inject.Inject

class TokenRoomDataSource @Inject constructor(
    private val userDao: AnonymousUserDao,
) : TokenLocalDataSource {

    override suspend fun createUser(user: AnonymousUserDb) {
        return userDao.insert(user)
    }

    override suspend fun deleteUser(user: AnonymousUserDb) {
        return userDao.delete(user)
    }

    override suspend fun updateUser(user: AnonymousUserDb) {
        return userDao.update(user)
    }

    override suspend fun getUser(): AnonymousUserDb? {
        return userDao.getAll()?.firstOrNull()
    }
}