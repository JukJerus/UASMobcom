package com.jukjerus.librarypro.presentation.books.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.jukjerus.librarypro.core.Constants.Companion.BOOKS_SCREEN

@Composable
fun BooksTopBar() {
    TopAppBar (
        title = {
            Text(
                text = BOOKS_SCREEN
            )
        }
    )
}