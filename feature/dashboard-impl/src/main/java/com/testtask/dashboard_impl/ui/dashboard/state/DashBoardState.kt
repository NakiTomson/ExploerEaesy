package com.testtask.dashboard_impl.ui.dashboard.state

import com.testtask.base.BaseState
import com.testtask.entity.BoardScreenEntity

// Все состояния экран DashBoard
sealed class DashBoardState(override vararg val subStates: DashBoardState) : BaseState {

    // Загрузка
    class DashBoardLoadingState(
        val isLoading: Boolean,
        override vararg val subStates: DashBoardState = arrayOf()
    ) : DashBoardState()

    // Нет скринов
    class DashBoardEmptyState(
        val isEmpty: Boolean,
        override vararg val subStates: DashBoardState = arrayOf()
    ) : DashBoardState()

    // ошибка загрузки
    class DashBoardErrorState(
        val isError: Boolean,
        override vararg val subStates: DashBoardState = arrayOf()
    ) : DashBoardState()

    // позиция скрина
    class DashBoardPositionState(
        val position: Int,
        override vararg val subStates: DashBoardState = arrayOf()
    ) : DashBoardState()

    // скрины загрузились
    class DashBoardLoadedState(
        val onBoardingPages: List<BoardScreenEntity>,
        override vararg val subStates: DashBoardState = arrayOf()
    ) : DashBoardState()

    // отрисовка всего состояния по дефолту
    open class RenderFullState(
        open val loadingState: DashBoardState = DashBoardLoadingState(false),
        open val emptyState: DashBoardState = DashBoardEmptyState(false),
        open val errorState: DashBoardState = DashBoardErrorState(false),
        open val dashBoardPositionState: DashBoardState = DashBoardPositionState(0),
        open val dashBoardLoadedState: DashBoardState = DashBoardLoadedState(listOf()),
        override vararg val subStates: DashBoardState = arrayOf(
            loadingState,
            emptyState,
            errorState,
            dashBoardPositionState,
            dashBoardLoadedState
        )
    ) : DashBoardState()

    // отрисовка одного или нескольких состояний
    open class RenderIndividuallyState(
        override vararg val subStates: DashBoardState = arrayOf()
    ) : RenderFullState()

    // отрисовка всего состояния, на основе старого состояния,
    // не рекомендуеться, стейт не должен копить состояние, а должен пораждать новое
    open class RenderFullStateWithLatestCopy(
        private val renderFullState: RenderFullState,
        override val loadingState: DashBoardState = renderFullState.loadingState,
        override val emptyState: DashBoardState = renderFullState.emptyState,
        override val errorState: DashBoardState = renderFullState.errorState,
        override val dashBoardPositionState: DashBoardState = renderFullState.dashBoardPositionState,
        override val dashBoardLoadedState: DashBoardState = renderFullState.dashBoardLoadedState,
        override vararg val subStates: DashBoardState = arrayOf(
            loadingState,
            emptyState,
            errorState,
            dashBoardPositionState,
            dashBoardLoadedState
        )
    ) : RenderFullState()
}
