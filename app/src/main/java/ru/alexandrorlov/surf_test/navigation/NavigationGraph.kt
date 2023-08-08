package ru.alexandrorlov.surf_test.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.alexandrorlov.surf_test.config.Constant.COCKTAIL_ID
import ru.alexandrorlov.surf_test.model.CocktailUi
import ru.alexandrorlov.surf_test.ui.detail.DetailScreen
import ru.alexandrorlov.surf_test.ui.list.ListScreen
import ru.alexandrorlov.surf_test.ui.main.MainScreen

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "MainScreen"
    ) {
        composable(
            route = "MainScreen",
        ) {
            MainScreen(
                navController = navController
            )
        }
        composable(
            route = "ListScreen"
        ) {
            ListScreen(
                cocktails = listOf(
                    CocktailUi(
                        id = 1,
                        title = "Pink Lemonade"
                    ),
                    CocktailUi(
                        id = 2,
                        title = "Mojito mocktail"
                    ),
                    CocktailUi(
                        id = 3,
                        title = "Goblet of Fire"
                    ),
                    CocktailUi(
                        id = 4,
                        title = "Purple rain"
                    ),
                    CocktailUi(
                        id = 5,
                        title = "Grapefruit Gin Fizz"
                    ),
                    CocktailUi(
                        id = 6,
                        title = "Mojito mocktail"
                    )
                ),
                navController = navController
            )
        }
        composable(
            route = "DetailScreen /{$COCKTAIL_ID}",
            arguments = listOf(
                navArgument(COCKTAIL_ID) { type = NavType.IntType }
            )
        ) {
            val id = it.arguments?.getInt(COCKTAIL_ID) ?: -1
            DetailScreen(
                id = id,
                navController = navController
            )
        }
    }
}