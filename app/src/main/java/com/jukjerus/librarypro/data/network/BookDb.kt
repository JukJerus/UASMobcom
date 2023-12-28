package com.jukjerus.librarypro.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jukjerus.librarypro.data.dao.BookDao
import com.jukjerus.librarypro.domain.model.Book

@Database(
    entities = [Book::class],
    version = 1,
    exportSchema = false
)
abstract class BookDb : RoomDatabase() {
    abstract val bookDao: BookDao
}