package com.testtask.interactors_impl

import com.testtask.interactors.DashBoardInteractor
import com.testtask.repositories.DashBoardRepository
import javax.inject.Inject

class DashBoardInteractorImpl @Inject constructor(
    private val dashBoardRepository: DashBoardRepository
) : DashBoardInteractor {

    override val dashBoardScreens = dashBoardRepository.dashBoardScreens

    override suspend fun loadDashBoardScreens() {
        dashBoardRepository.loadDashBoardScreens()
    }
}