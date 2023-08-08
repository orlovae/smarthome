package ru.alexandrorlov.surf_test.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.alexandrorlov.surf_test.R
import ru.alexandrorlov.surf_test.ui.main.component.MainFAB
import ru.alexandrorlov.surf_test.ui.main.component.Title
import ru.alexandrorlov.surf_test.ui.theme.SurfTestTypography
import ru.alexandrorlov.surf_test.ui.theme.padding_main_logo
import ru.alexandrorlov.surf_test.ui.theme.padding_normal

@Composable
internal fun MainScreen(
    navController: NavHostController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        modifier = Modifier,
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), contentAlignment = BottomCenter
            ) {
                Image(
                    modifier = Modifier
                        .padding(
                            start = padding_main_logo,
                            end = padding_main_logo,
                            top = padding_main_logo,
                            bottom = padding_normal
                        )
                        .fillMaxSize(),
                    painter = painterResource(id = R.drawable.main_logo),
                    contentDescription = ""
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = BottomCenter
            ) {
                Column(
                    modifier = Modifier
                        .padding(bottom = padding_normal),
                    horizontalAlignment = CenterHorizontally
                ) {
                    Title(
                        text = stringResource(id = R.string.app_name)
                    )
                    Text(
                        text = stringResource(id = R.string.description),
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(
                                top = padding_normal, bottom = padding_normal
                            ),
                        maxLines = 2,
                        style = SurfTestTypography.titleMedium,
                        overflow = TextOverflow.Visible,
                        textAlign = TextAlign.Center
                    )
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = padding_normal, bottom = padding_normal
                            ),
                        painter = painterResource(id = R.drawable.down),
                        contentDescription = ""
                    )
                    MainFAB(
                        navController = navController
                    )
                }
            }
        }
    }
}