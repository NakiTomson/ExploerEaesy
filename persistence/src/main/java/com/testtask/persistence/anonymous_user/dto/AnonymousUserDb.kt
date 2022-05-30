package com.testtask.persistence.anonymous_user.dto

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.testtask.persistence.anonymous_user.dto.AnonymousUserDb.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME, primaryKeys = ["accessTime", "anonymousToken"])
data class AnonymousUserDb(
    @ColumnInfo(name = "isOnBoarded") val isOnBoarded: Boolean?,
    @ColumnInfo(name = "anonymousToken", defaultValue = "anonymousToken") val anonymousToken: String,
    @ColumnInfo(name = "accessTime", defaultValue = "0") val accessTime: Long,
) {
    companion object {
        internal const val TABLE_NAME = "anonymous_user"
    }
}

