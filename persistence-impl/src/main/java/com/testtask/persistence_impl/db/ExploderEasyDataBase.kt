package com.testtask.persistence_impl.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.testtask.persistence.dao.AnonymousUserDao
import com.testtask.persistence.anonymous_user.dto.AnonymousUserDb

@Database(entities = [AnonymousUserDb::class], version = 1)
abstract class ExploderEasyDataBase : RoomDatabase() {
    abstract fun anonymousUserDao(): AnonymousUserDao
}