package com.example.hotplenavigation.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// 20165304 김성곤
// Room DB를 사용하기 위한 Database 클래스 작성
@Database(
    entities = [BookmarkFragmentEntity::class],
    version = 2,
    exportSchema = false
)
abstract class BookmarkFragmentDatabase : RoomDatabase() {

    abstract fun getBookmarkFragmentDao(): BookmarkFragmentDao

    companion object {
        private var INSTANCE: BookmarkFragmentDatabase? = null

        fun getSearchFragmentInstance(context: Context): BookmarkFragmentDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    BookmarkFragmentDatabase::class.java,
                    "BookmarkFragmentDB"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE!!
        }
    }
}
