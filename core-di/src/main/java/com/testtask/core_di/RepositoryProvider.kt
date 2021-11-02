package com.testtask.core_di

import com.testtask.interactors.DashBoardInteractor
import com.testtask.interactors.SplashInteractor
import com.testtask.repositories.DashBoardRepository

interface RepositoryProvider {

    fun provideDashBoardRepository(): DashBoardRepository
}
