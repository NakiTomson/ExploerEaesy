package com.testtask.persistence.anonymous_user

import com.testtask.persistence.anonymous_user.dto.AnonymousUserDb

interface TokenLocalDataSource {
    fun createUser(user: AnonymousUserDb)
    fun deleteUser(user: AnonymousUserDb)
    fun updateUser(user: AnonymousUserDb)
    fun getUser(): AnonymousUserDb?
}