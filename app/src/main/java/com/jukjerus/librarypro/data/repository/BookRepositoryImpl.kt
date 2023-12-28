package com.jukjerus.librarypro.data.repository

import com.jukjerus.librarypro.data.dao.BookDao
import com.jukjerus.librarypro.domain.model.Book
import com.jukjerus.librarypro.domain.repository.BookRepository

class BookRepositoryImpl(
    private val bookDao: BookDao
) : BookRepository {
    override fun getBooksFromRoom() = bookDao.getBooks()

    override suspend fun getBookFromRoom(id: Int) = bookDao.getBook(id)

    override suspend fun addBookToRoom(book: Book) = bookDao.addBook(book)

    override suspend fun updateBookInRoom(book: Book) = bookDao.updateBook(book)

    override suspend fun deleteBookFromRoom(book: Book) = bookDao.deleteBook(book)
}