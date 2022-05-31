package com.testtask.persistence.dao

import androidx.room.*
import com.testtask.persistence.anonymous_user.dto.AnonymousUserDb

@Dao
interface AnonymousUserDao {

    @Query("SELECT * FROM anonymous_user")
    suspend fun getAll(): List<AnonymousUserDb>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(anonymousUser: AnonymousUserDb)

    @Update
    suspend fun update(anonymousUser: AnonymousUserDb)

    @Delete
    suspend fun delete(anonymousUser: AnonymousUserDb)

}