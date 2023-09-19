package ru.alexandrorlov.smarthome.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.alexandrorlov.smarthome.config.NavigationDestination.DESTINATION_CAMERA
import ru.alexandrorlov.smarthome.ui.camera.CameraStateManger

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = DESTINATION_CAMERA
    ) {
        composable(
            route = DESTINATION_CAMERA
        ) {
            CameraStateManger(
                viewModel = hiltViewModel()
            )
        }
    }
}