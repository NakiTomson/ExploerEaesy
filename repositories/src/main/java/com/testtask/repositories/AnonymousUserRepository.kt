package com.testtask.repositories

import com.testtask.persistence.dto.AnonymousUserDb

interface AnonymousUserRepository {

    fun addAnonymousUser(anonymousUserDb: AnonymousUserDb)

    fun removeAnonymousUser(anonymousUserDb: AnonymousUserDb)

}