package com.testtask.persistence.anonymous_user

import com.testtask.persistence.anonymous_user.dto.AnonymousUserDb

interface TokenLocalDataSource {
    suspend fun createUser(user: AnonymousUserDb)
    suspend fun deleteUser(user: AnonymousUserDb)
    suspend fun updateUser(user: AnonymousUserDb)
    suspend fun getUser(): AnonymousUserDb?
}