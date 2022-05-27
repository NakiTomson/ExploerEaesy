package com.testtask.persistence.anonymous_user.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.testtask.persistence.anonymous_user.dto.AnonymousUserDb.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class AnonymousUserDb(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val isOnBoarded: Boolean?,
    val anonymousToken: String?
) {
    companion object {
        internal const val TABLE_NAME = "anonymous_user"
    }
}