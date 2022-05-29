package com.testtask.persistence_impl.anonymous_user.local

import com.testtask.persistence.anonymous_user.AnonymousUserLocalDataSource
import com.testtask.persistence.anonymous_user.dto.AnonymousUserDb
import com.testtask.persistence.dao.AnonymousUserDao
import javax.inject.Inject

class RoomAnonymousUserDataSource @Inject constructor(
    private val userDao: AnonymousUserDao,
) : AnonymousUserLocalDataSource {

    override fun createUser(user: AnonymousUserDb) {
        userDao.insert(user)
    }

    override fun deleteUser(user: AnonymousUserDb) {
        userDao.delete(user)
    }

    override fun updateUser(user: AnonymousUserDb) {
        userDao.update(user)
    }

    override fun getUser(): AnonymousUserDb? {
        return userDao.getAll()?.firstOrNull()
    }
}