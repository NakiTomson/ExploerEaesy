package com.testtask.interactors_impl

import com.testtask.core_di.dispatchers.Dispatchers
import com.testtask.interactors.SplashInteractor
import com.testtask.repositories.TokenRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SplashInteractorImpl @Inject constructor(
    private val tokenRepository: TokenRepository,
    private val dispatchers: Dispatchers,
) : SplashInteractor {


    override suspend fun createAnonymousSession() = withContext(dispatchers.io) {
        val invalidToken = System.currentTimeMillis() > (tokenRepository.getAnonymousUserOrNull()?.accessTime ?: 0)
        if (invalidToken) tokenRepository.createAnonymousUser()
    }
}