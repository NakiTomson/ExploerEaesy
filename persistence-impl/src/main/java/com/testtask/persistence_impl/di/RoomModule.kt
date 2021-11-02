package com.testtask.persistence_impl.di

import android.content.Context
import androidx.room.Room
import com.testtask.persistence.dao.AnonymousUserDao
import com.testtask.persistence_impl.db.ExploderEasyDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface RoomModule {


    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun provideDataBase(context: Context): ExploderEasyDataBase {
            return Room.databaseBuilder(context, ExploderEasyDataBase::class.java, "explodereas.db").build()
        }

        @Provides
        @Singleton
        @JvmStatic
        fun provideAnonymousUserDao(db: ExploderEasyDataBase): AnonymousUserDao {
            return db.anonymousUserDao()
        }
    }

}