package ru.alexandrorlov.smarthome.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.alexandrorlov.smarthome.ui.camera.CameraScreen

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "camera"
    ) {
        composable(
            route = "camera"
        ) {
            CameraScreen(
                viewModel = hiltViewModel()
            )
        }
    }
}