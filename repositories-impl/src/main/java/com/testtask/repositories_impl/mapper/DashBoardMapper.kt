package com.testtask.repositories_impl.mapper

import com.testtask.entity.BoardScreenEntity
import com.testtask.network.response.DashBoardScreenResponse


fun List<DashBoardScreenResponse>.toDashBoardScreensEntity(): List<BoardScreenEntity> {
    return map { it.toDashBoardScreenEntities() }
}

fun DashBoardScreenResponse.toDashBoardScreenEntities(): BoardScreenEntity {
    return BoardScreenEntity(title, text, media)
}
