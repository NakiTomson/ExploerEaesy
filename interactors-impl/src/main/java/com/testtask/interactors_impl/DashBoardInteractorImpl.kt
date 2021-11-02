package com.testtask.interactors_impl

import com.testtask.entity.BoardScreenEntity
import com.testtask.interactors.DashBoardInteractor
import com.testtask.repositories.DashBoardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DashBoardInteractorImpl @Inject constructor(
    private val dashBoardRepository: DashBoardRepository
) : DashBoardInteractor {

    override val dashBoardScreens: Flow<List<BoardScreenEntity>> = flow {
        emit(loadDashBoardScreens())
    }

    private suspend fun loadDashBoardScreens(): List<BoardScreenEntity> {
        return dashBoardRepository.loadDashBoardScreens()
    }
}