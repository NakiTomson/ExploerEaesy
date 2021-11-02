package com.testtask.persistence.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anonymous_user")
data class AnonymousUserDb(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val onBoarded: Boolean?
)