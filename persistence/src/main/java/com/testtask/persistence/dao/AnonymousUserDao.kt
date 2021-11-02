package com.testtask.persistence.dao

import androidx.room.*
import com.testtask.persistence.dto.AnonymousUserDb

@Dao
interface AnonymousUserDao {

    @Query("SELECT * FROM anonymous_user")
    fun getAll(): List<AnonymousUserDb>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(anonymousUser: AnonymousUserDb)

    @Update
    fun update(anonymousUser: AnonymousUserDb)

    @Delete
    fun delete(anonymousUser: AnonymousUserDb)

}