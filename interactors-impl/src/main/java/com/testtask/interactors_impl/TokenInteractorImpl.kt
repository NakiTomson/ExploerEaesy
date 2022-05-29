package com.testtask.interactors_impl

import com.testtask.core_di.dispatchers.Dispatchers
import com.testtask.interactors.TokenInteractor
import com.testtask.repositories.TokenRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TokenInteractorImpl @Inject constructor(
    private val tokenRepository: TokenRepository,
    private val dispatchers: Dispatchers,
) : TokenInteractor {


    override suspend fun createAnonymousSession() = withContext(dispatchers.io) {
        val invalidToken = System.currentTimeMillis() > (tokenRepository.getAnonymousUserOrNull()?.accessTime ?: 0)
        if (invalidToken) tokenRepository.createAnonymousUser()
    }
}