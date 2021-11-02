package com.testtask.network.errors

open class ServerError : Throwable() {
    class UndefinedError : ServerError()
}