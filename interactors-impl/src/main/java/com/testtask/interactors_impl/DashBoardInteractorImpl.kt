package com.testtask.interactors_impl

import com.testtask.core_di.dispatchers.Dispatchers
import com.testtask.interactors.DashBoardInteractor
import com.testtask.repositories.DashBoardRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DashBoardInteractorImpl @Inject constructor(
    private val dashBoardRepository: DashBoardRepository,
    private val dispatchers: Dispatchers,
) : DashBoardInteractor {

    override val dashBoardScreens = dashBoardRepository.dashBoardScreens

    override suspend fun loadDashBoardScreens() = withContext(dispatchers.io) {
        dashBoardRepository.loadDashBoardScreens()
    }
}