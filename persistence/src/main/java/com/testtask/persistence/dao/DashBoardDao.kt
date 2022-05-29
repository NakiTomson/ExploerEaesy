package com.testtask.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.testtask.persistence.dash_board.dto.DashBoardScreenDb

@Dao
interface DashBoardDao {

    @Query("SELECT * FROM dash_board_screen")
    fun getAll(): List<DashBoardScreenDb>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(anonymousUser: DashBoardScreenDb)

}