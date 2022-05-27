package com.testtask.interactors_impl

import com.testtask.interactors.SplashInteractor
import com.testtask.repositories.TokenRepository
import javax.inject.Inject

class SplashInteractorImpl @Inject constructor(
    private val tokenRepository: TokenRepository
) : SplashInteractor {


    override suspend fun createAnonymousSession() {
        tokenRepository.createAnonymousUser()
    }
}