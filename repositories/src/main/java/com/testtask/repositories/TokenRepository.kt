package com.testtask.repositories

import com.testtask.entity.AnonymousUserEntity

interface TokenRepository {

    suspend fun createAnonymousUser()

    suspend fun updateAnonymousUser(anonymousUserEntity: AnonymousUserEntity)

    suspend fun getAnonymousUserOrNull(): AnonymousUserEntity?
}