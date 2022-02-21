package com.testtask.entity

open class ServerError : Throwable() {
    class UndefinedError : ServerError()
    class NotError : ServerError()
}