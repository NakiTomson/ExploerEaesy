package com.testtask.interactors

import kotlinx.coroutines.flow.Flow

interface SplashInteractor {

    val closeSplashFlow: Flow<Unit>
    val openDashBoardFlow: Flow<Unit>
    val openMainFlow: Flow<Unit>
}