package com.testtask.repositories_impl

import com.testtask.persistence.dao.AnonymousUserDao
import com.testtask.persistence.dto.AnonymousUserDb
import com.testtask.repositories.AnonymousUserRepository
import javax.inject.Inject

class AnonymousUserRepositoryImpl @Inject constructor(
    private val anonymousUserDao: AnonymousUserDao,
) : AnonymousUserRepository {

    override fun addAnonymousUser(anonymousUserDb: AnonymousUserDb) {

    }

    override fun removeAnonymousUser(anonymousUserDb: AnonymousUserDb) {

    }
}