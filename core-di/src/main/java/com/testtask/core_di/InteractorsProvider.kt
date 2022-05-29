package com.testtask.core_di

import com.testtask.interactors.DashBoardInteractor
import com.testtask.interactors.TokenInteractor

interface InteractorsProvider {

    fun provideSplashInteractor(): TokenInteractor

    fun provideDashBoardInteractor(): DashBoardInteractor
}
