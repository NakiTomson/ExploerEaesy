package com.testtask.persistence_impl.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.testtask.persistence.anonymous_user.dto.AnonymousUserDb
import com.testtask.persistence.dao.AnonymousUserDao
import com.testtask.persistence.dao.DashBoardDao
import com.testtask.persistence.dash_board.dto.DashBoardScreenDb

@Database(
    version = 1,
    exportSchema = true,
    entities = [AnonymousUserDb::class, DashBoardScreenDb::class],
//    autoMigrations = [
//        AutoMigration(from = 1, to = 2)
//    ],
)
abstract class ExploderEasyDataBase : RoomDatabase() {
    abstract fun anonymousUserDao(): AnonymousUserDao
    abstract fun dashBoardDao(): DashBoardDao
}