package com.testtask.network.service

interface ServiceFactory {
    fun <S> createService(serviceClass: Class<S>): S
}