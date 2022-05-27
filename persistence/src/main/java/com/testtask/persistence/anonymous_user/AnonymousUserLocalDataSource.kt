package com.testtask.persistence.anonymous_user

import com.testtask.persistence.anonymous_user.dto.AnonymousUserDb

interface AnonymousUserLocalDataSource {
    fun createUser(user: AnonymousUserDb): Boolean
    fun deleteUser(user: AnonymousUserDb): Boolean
    fun updateUser(user: AnonymousUserDb): Boolean
    fun getUser(): AnonymousUserDb?
}