package com.testtask.interactors_impl

import com.testtask.interactors.SplashInteractor
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SplashInteractorImpl @Inject constructor() : SplashInteractor {

    override val openDashBoardFlow: Flow<Unit> = flow {
        delay(2000)
        emit(Unit)
    }

    override val closeSplashFlow: Flow<Unit> = flow {
        delay(2000)
        emit(Unit)
    }

    override val openMainFlow: Flow<Unit> = flow {
        delay(2000)
        emit(Unit)
    }

}