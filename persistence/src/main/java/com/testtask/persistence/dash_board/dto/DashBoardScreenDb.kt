package com.testtask.persistence.dash_board.dto

import androidx.room.*
import com.testtask.persistence.dash_board.dto.DashBoardScreenDb.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME, indices = [Index(value = ["title", "text"], unique = true)])
data class DashBoardScreenDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "text") val text: String?,
    @ColumnInfo(name = "media", index = true) val media: String?
) {

    companion object {
        internal const val TABLE_NAME = "dash_board_screen"
    }
}
