package com.testtask.repositories

import com.testtask.entity.AnonymousUserEntity

interface AnonymousUserRepository {

    suspend fun createAnonymousUser()

    suspend fun updateAnonymousUser(anonymousUserEntity: AnonymousUserEntity)
}