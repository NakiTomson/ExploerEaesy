package com.testtask.entity


data class Resource<T>(
    var status: Status = Status.LOADING,
    val data: T,
    val exception: ServerError = ServerError.NotError()
) {
    enum class Status {
        LOADING,
        COMPLETED,
        EMPTY,
        ERROR,
        UNDEFINED,
    }
}