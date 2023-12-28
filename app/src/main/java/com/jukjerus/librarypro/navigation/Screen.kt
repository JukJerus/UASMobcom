package com.jukjerus.librarypro.navigation

import com.jukjerus.librarypro.core.Constants.Companion.BOOKS_SCREEN
import com.jukjerus.librarypro.core.Constants.Companion.UPDATE_BOOK_SCREEN

sealed class Screen(val route: String) {
    object BooksScreen: Screen(BOOKS_SCREEN)
    object UpdateBookScreen: Screen(UPDATE_BOOK_SCREEN)
}