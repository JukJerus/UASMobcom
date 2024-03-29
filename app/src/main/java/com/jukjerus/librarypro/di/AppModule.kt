package com.jukjerus.librarypro.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.jukjerus.librarypro.core.Constants.Companion.BOOK_TABLE
import com.jukjerus.librarypro.data.dao.BookDao
import com.jukjerus.librarypro.data.network.BookDb
import com.jukjerus.librarypro.data.repository.BookRepositoryImpl
import com.jukjerus.librarypro.domain.repository.BookRepository

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideBookDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        BookDb::class.java,
        BOOK_TABLE
    ).build()

    @Provides
    fun provideBookDao(
        bookDb: BookDb
    ) = bookDb.bookDao

    @Provides
    fun provideBookRepository(
        bookDao: BookDao
    ): BookRepository = BookRepositoryImpl(
        bookDao = bookDao
    )
}