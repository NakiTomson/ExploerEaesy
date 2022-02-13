package com.testtask.base

interface BaseState {

    val subStates: Array<out BaseState>
}