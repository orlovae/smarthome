package ru.alexandrorlov.smarthome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.debounce
import ru.alexandrorlov.smarthome.navigation.NavigationManager
import ru.alexandrorlov.smarthome.ui.main.MainScreen
import ru.alexandrorlov.smarthome.ui.theme.SmarthomeTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    internal lateinit var navigationManager: NavigationManager


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            LaunchedEffect(key1 = Unit) {
                navigationManager.sharedFlow.debounce { 100L }.collect {
                    if (it.destination == "OnBack") {
                        navController.popBackStack()
                    } else {
                        navController.navigate(it.destination)
                    }
                }
            }
            SmarthomeTheme {
                Scaffold() { paddingValues ->
                    MainScreen(
                        paddingValues = paddingValues,
                        navController = navController
                    )
                }
            }
        }
    }
}