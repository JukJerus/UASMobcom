package com.jukjerus.librarypro.domain.repository

import kotlinx.coroutines.flow.Flow
import com.jukjerus.librarypro.domain.model.Book

typealias Books = List<Book>

interface BookRepository {
    fun getBooksFromRoom(): Flow<Books>

    suspend fun getBookFromRoom(id: Int): Book

    suspend fun addBookToRoom(book: Book)

    suspend fun updateBookInRoom(book: Book)

    suspend fun deleteBookFromRoom(book: Book)
}