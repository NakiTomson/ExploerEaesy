package com.testtask.persistence.anonymous_user.mapper

import com.testtask.Resource
import com.testtask.entity.AnonymousUserEntity
import com.testtask.network.response.AnonymousUserResponse
import com.testtask.persistence.anonymous_user.dto.AnonymousUserDb


fun AnonymousUserResponse.toUserBb(currentTimeMillis: Long): AnonymousUserDb {
    return AnonymousUserDb(
        isOnBoarded = false,
        anonymousToken = anonymousToken,
        accessTime = accessTime?.toLong()?.plus(currentTimeMillis)
    )
}

fun AnonymousUserEntity.toUserBb(currentTimeMillis: Long): AnonymousUserDb {
    return AnonymousUserDb(
        isOnBoarded = isOnBoarded,
        anonymousToken = anonymousToken,
        accessTime = accessTime?.plus(currentTimeMillis)
    )
}

fun AnonymousUserResponse.toUserEntity(isOnBoarded: Boolean): AnonymousUserEntity {
    return AnonymousUserEntity(isOnBoarded = isOnBoarded, anonymousToken = anonymousToken, accessTime = accessTime?.toLong())
}

fun AnonymousUserDb.toUserEntity(): AnonymousUserEntity {
    return AnonymousUserEntity(isOnBoarded = isOnBoarded, anonymousToken = anonymousToken, accessTime = accessTime)
}

fun AnonymousUserResponse.toResource(): Resource<AnonymousUserResponse> {
    val status = if (this.anonymousToken.isNullOrBlank()) Resource.Status.EMPTY else Resource.Status.COMPLETED
    return Resource(status, this)
}
