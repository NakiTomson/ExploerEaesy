package com.testtask.repositories_impl.dashboard.mapper

import com.testtask.Resource
import com.testtask.Resource.Status
import com.testtask.entity.DashBoardScreenEntity
import com.testtask.network.response.DashBoardScreenResponse
import com.testtask.persistence.dash_board.dto.DashBoardScreenDb


fun List<DashBoardScreenResponse>.toResource(): Resource<List<DashBoardScreenEntity>> {
    val status = if (this.isEmpty()) Status.EMPTY else Status.COMPLETED
    return Resource(status, this.toDashBoardScreensEntity())
}

fun List<DashBoardScreenResponse>.toDashBoardScreensEntity(): List<DashBoardScreenEntity> {
    return map { it.toDashBoardScreenEntities() }
}

fun List<DashBoardScreenEntity>.toDashBoardScreensDb(): List<DashBoardScreenDb> {
    return map { it.toDashBoardScreensDb() }
}

fun DashBoardScreenEntity.toDashBoardScreensDb(): DashBoardScreenDb {
    return DashBoardScreenDb(title = title, text = text, media = media)
}

fun Resource<List<DashBoardScreenDb>>.toDashBoardScreensEntity(): Resource<List<DashBoardScreenEntity>> {
    return Resource(status, data.toDashBoardScreensDbEntity(), exception)
}

fun List<DashBoardScreenDb>.toDashBoardScreensDbEntity(): List<DashBoardScreenEntity> {
    return map { it.toDashBoardScreensEntity() }
}

fun DashBoardScreenDb.toDashBoardScreensEntity(): DashBoardScreenEntity {
    return DashBoardScreenEntity(title = title!!, text = text!!, media = media!!)
}


fun DashBoardScreenResponse.toDashBoardScreenEntities(): DashBoardScreenEntity {
    return DashBoardScreenEntity(title, text, media)
}
