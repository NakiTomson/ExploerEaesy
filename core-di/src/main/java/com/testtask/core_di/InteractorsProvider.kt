package com.testtask.core_di

import com.testtask.interactors.DashBoardInteractor
import com.testtask.interactors.SplashInteractor

interface InteractorsProvider {

    fun provideSplashInteractor(): SplashInteractor

    fun provideDashBoardInteractor(): DashBoardInteractor
}
