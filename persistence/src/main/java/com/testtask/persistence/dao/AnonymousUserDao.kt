package com.testtask.persistence.dao

import androidx.room.*
import com.testtask.persistence.anonymous_user.dto.AnonymousUserDb

@Dao
interface AnonymousUserDao {

    @Query("SELECT * FROM anonymous_user")
    fun getAll(): List<AnonymousUserDb>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(anonymousUser: AnonymousUserDb): Boolean

    @Update
    fun update(anonymousUser: AnonymousUserDb): Boolean

    @Delete
    fun delete(anonymousUser: AnonymousUserDb): Boolean

}