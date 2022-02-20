package com.testtask.repositories_impl.mapper

import com.testtask.entity.DashBoardScreenEntity
import com.testtask.entity.Resource
import com.testtask.entity.Resource.Status
import com.testtask.network.response.DashBoardScreenResponse


fun List<DashBoardScreenResponse>.toResource(): Resource<List<DashBoardScreenEntity>> {
    val status = if (this.isEmpty()) Status.EMPTY else Status.COMPLETED
    return Resource(status, this.toDashBoardScreensEntity())
}

fun List<DashBoardScreenResponse>.toDashBoardScreensEntity(): List<DashBoardScreenEntity> {
    return map { it.toDashBoardScreenEntities() }
}

fun DashBoardScreenResponse.toDashBoardScreenEntities(): DashBoardScreenEntity {
    return DashBoardScreenEntity(title, text, media)
}
