package com.testtask.persistence_impl.anonymous_user.local

import com.testtask.persistence.anonymous_user.TokenLocalDataSource
import com.testtask.persistence.anonymous_user.dto.AnonymousUserDb
import com.testtask.persistence.dao.AnonymousUserDao
import javax.inject.Inject

class RoomTokenDataSource @Inject constructor(
    private val userDao: AnonymousUserDao,
) : TokenLocalDataSource {

    override fun createUser(user: AnonymousUserDb) {
        return userDao.insert(user)
    }

    override fun deleteUser(user: AnonymousUserDb) {
        return userDao.delete(user)
    }

    override fun updateUser(user: AnonymousUserDb) {
        return userDao.update(user)
    }

    override fun getUser(): AnonymousUserDb? {
        return userDao.getAll()?.firstOrNull()
    }
}