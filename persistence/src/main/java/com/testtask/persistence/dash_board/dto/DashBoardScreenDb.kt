package com.testtask.persistence.dash_board.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.testtask.persistence.dash_board.dto.DashBoardScreenDb.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class DashBoardScreenDb(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String?,
    val text: String?,
    val media: String?
) {

    companion object {
        internal const val TABLE_NAME = "dash_board_screen"
    }
}