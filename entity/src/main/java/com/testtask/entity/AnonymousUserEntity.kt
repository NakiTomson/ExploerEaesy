package com.testtask.entity

data class AnonymousUserEntity(
    val isOnBoarded: Boolean?,
    val anonymousToken: String?,
    val accessTime: Long?
)