package ru.alexandrorlov.surf_test.ui.main.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.alexandrorlov.surf_test.R
import ru.alexandrorlov.surf_test.ui.theme.ButtonBlueBackground

@Composable
internal fun MainFAB(
    navController: NavController
) {
    FilledIconButton(
        modifier = Modifier
            .size(80.dp),
        onClick = {
            navController.navigate("ListScreen")
        },
        shape = IconButtonDefaults.filledShape,
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = ButtonBlueBackground,
            contentColor = Color.White,
        ),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_add_24),
            contentDescription = ""
        )
    }
}