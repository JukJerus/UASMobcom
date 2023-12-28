package com.jukjerus.librarypro.data.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import kotlinx.coroutines.flow.Flow
import com.jukjerus.librarypro.core.Constants.Companion.BOOK_TABLE
import com.jukjerus.librarypro.domain.model.Book
import com.jukjerus.librarypro.domain.repository.Books

@Dao
interface BookDao {
    @Query("SELECT * FROM $BOOK_TABLE ORDER BY id ASC")
    fun getBooks(): Flow<Books>

    @Query("SELECT * FROM $BOOK_TABLE WHERE id = :id")
    suspend fun getBook(id: Int): Book

    @Insert(onConflict = IGNORE)
    suspend fun addBook(book: Book)

    @Update
    suspend fun updateBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)
}