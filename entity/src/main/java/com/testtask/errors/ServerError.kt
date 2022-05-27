package com.testtask.errors

open class ServerError : Throwable() {
    class UndefinedError : ServerError()
    class NotError : ServerError()
}