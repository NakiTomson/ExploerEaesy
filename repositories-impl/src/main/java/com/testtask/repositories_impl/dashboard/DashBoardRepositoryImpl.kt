package com.testtask.repositories_impl.dashboard


import com.testtask.Resource
import com.testtask.Resource.Status
import com.testtask.entity.DashBoardScreenEntity
import com.testtask.persistence.dash_board.DashBoardLocalDataSource
import com.testtask.repositories.DashBoardRepository
import com.testtask.repositories_impl.dashboard.mapper.toDashBoardScreensDb
import com.testtask.repositories_impl.dashboard.mapper.toDashBoardScreensEntity
import com.testtask.source.DashBoardRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class DashBoardRepositoryImpl @Inject constructor(
    private val remoteDataSource: DashBoardRemoteDataSource,
    private val localDataSource: DashBoardLocalDataSource,
) : DashBoardRepository {

    private val _dashBoardScreens: MutableSharedFlow<Resource<List<DashBoardScreenEntity>>> =
        MutableStateFlow(Resource(Status.UNDEFINED, listOf()))

    override val dashBoardScreens: Flow<Resource<List<DashBoardScreenEntity>>> = _dashBoardScreens.asSharedFlow()

    override suspend fun getDashBoardScreens() {
        _dashBoardScreens.emit(Resource(Status.LOADING, listOf()))
        val result = localDataSource.getDashBoards().run {
            if (this.status != Status.COMPLETED)
                localDataSource.createDashBoard(remoteDataSource.loadDashBoardScreens().data.toDashBoardScreensDb())
            localDataSource.getDashBoards().toDashBoardScreensEntity()
        }
        _dashBoardScreens.emit(result)
    }
}