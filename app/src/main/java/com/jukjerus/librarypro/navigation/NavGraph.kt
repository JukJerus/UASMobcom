package com.jukjerus.librarypro.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jukjerus.librarypro.core.Constants.Companion.BOOK_ID
import com.jukjerus.librarypro.navigation.Screen.BooksScreen
import com.jukjerus.librarypro.navigation.Screen.UpdateBookScreen
import com.jukjerus.librarypro.presentation.books.BooksScreen
import com.jukjerus.librarypro.presentation.update_book.UpdateBookScreen

@Composable
@ExperimentalMaterialApi
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BooksScreen.route
    ) {
        composable(
            route = BooksScreen.route
        ) {
            BooksScreen(
                navigateToUpdateBookScreen = { bookId ->
                    navController.navigate(
                        route = "${UpdateBookScreen.route}/${bookId}"
                    )
                }
            )
        }
        composable(
            route = "${UpdateBookScreen.route}/{$BOOK_ID}",
            arguments = listOf(
                navArgument(BOOK_ID) {
                    type = IntType
                }
            )
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt(BOOK_ID) ?: 0
            UpdateBookScreen(
                bookId = bookId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}