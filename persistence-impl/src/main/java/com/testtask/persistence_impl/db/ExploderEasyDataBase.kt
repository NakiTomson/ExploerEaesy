package com.testtask.persistence_impl.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.testtask.persistence.anonymous_user.dto.AnonymousUserDb
import com.testtask.persistence.dao.AnonymousUserDao

@Database(
    version = 2,
    exportSchema = false,
    entities = [AnonymousUserDb::class],
//    autoMigrations = [
//        AutoMigration(from = 1, to = 2)
//    ],
)
abstract class ExploderEasyDataBase : RoomDatabase() {
    abstract fun anonymousUserDao(): AnonymousUserDao
}