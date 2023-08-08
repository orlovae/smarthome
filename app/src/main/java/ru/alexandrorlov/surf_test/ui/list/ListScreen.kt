package ru.alexandrorlov.surf_test.ui.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import ru.alexandrorlov.surf_test.R
import ru.alexandrorlov.surf_test.model.CocktailUi
import ru.alexandrorlov.surf_test.ui.list.component.CocktailCard
import ru.alexandrorlov.surf_test.ui.main.component.MainFAB
import ru.alexandrorlov.surf_test.ui.main.component.Title
import ru.alexandrorlov.surf_test.ui.theme.padding_medium


@Composable
internal fun ListScreen(
    cocktails: List<CocktailUi>,
    navController: NavController
) {
    Scaffold(
        modifier = Modifier
            .padding(
                bottom = padding_medium
            ),
        bottomBar = {
            BottomAppBar {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    MainFAB(navController = navController)
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Title(
                text = stringResource(id = R.string.app_name)
            )
            LazyVerticalGrid(
                modifier = Modifier
                    .padding(
                        start = padding_medium,
                        end = padding_medium
                    ),
                columns = GridCells.Fixed(2)
            ) {
                items(cocktails) { cocktail ->
                    CocktailCard(
                        navController = navController,
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        title = cocktail.title,
                        id = cocktail.id
                    )
                }
            }
        }
    }
}