package ru.alexandrorlov.surf_test.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import coil.compose.AsyncImage
import ru.alexandrorlov.surf_test.R
import ru.alexandrorlov.surf_test.model.CocktailUi
import ru.alexandrorlov.surf_test.ui.detail.component.DetailScreenText
import ru.alexandrorlov.surf_test.ui.detail.component.DetailScreenTextWithSpacer
import ru.alexandrorlov.surf_test.ui.theme.SurfTestTypography
import ru.alexandrorlov.surf_test.ui.theme.padding_detail
import ru.alexandrorlov.surf_test.ui.theme.padding_normal
import ru.alexandrorlov.surf_test.ui.theme.radius_large

@Composable
internal fun DetailScreen(
    navController: NavController,
    id: Int,
) {
    val cocktail = Data.cocktail
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        AsyncImage(
            model = cocktail.urlThumb,
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            error = painterResource(id = R.drawable.ic_launcher_error),
            contentDescription = "",
            modifier = Modifier
                .fillMaxHeight(),
            contentScale = ContentScale.Fit

        )
        Card(
            modifier = Modifier
                .fillMaxHeight(0.75f)
                .verticalScroll(rememberScrollState()),
            shape = RoundedCornerShape(radius_large),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = padding_detail,
                        bottom = padding_normal
                    ),
                text = cocktail.title,
                maxLines = 1,
                style = SurfTestTypography.titleLarge,
                overflow = TextOverflow.Visible,
                textAlign = TextAlign.Center
            )

            if (cocktail.description?.isNotEmpty() == true) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            bottom = padding_normal
                        ),
                    text = cocktail.description,
                    style = SurfTestTypography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
            val ingredients = cocktail.ingredients

            if (ingredients?.isNotEmpty() == true) {
                ingredients.forEachIndexed() { index, ingredient ->
                    if (index != ingredients.lastIndex) {
                        DetailScreenTextWithSpacer(text = ingredient)
                    } else {
                        DetailScreenText(text = ingredient)
                    }
                }
            }

            if (cocktail.recipe?.isNotEmpty() == true) {
                DetailScreenText(text = cocktail.recipe)
            }
        }
    }
}

private object Data {
    val cocktail = CocktailUi(
        id = 1,
        title = "Pink Lemonade",
        description = "To make this homemade pink lemonade, simply combine all the ingredients in a pitcher.",
        ingredients = listOf(
            "9 cups water",
            "2 cups white sugar",
            "2 cups fresh lemon juice",
            "1 cup cranberry juice, chilled",
            "ice as needed",
            "9 cups water",
            "2 cups white sugar",
            "2 cups fresh lemon juice",
            "1 cup cranberry juice, chilled",
            "9 cups water",
            "2 cups white sugar",
            "2 cups fresh lemon juice",
            "1 cup cranberry juice, chilled",
        ),
    )
}