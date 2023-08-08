package ru.alexandrorlov.surf_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.debounce
import ru.alexandrorlov.surf_test.navigation.NavigationGraph
import ru.alexandrorlov.surf_test.navigation.NavigationManager
import ru.alexandrorlov.surf_test.ui.theme.SurfTestTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    internal lateinit var navigationManager: NavigationManager

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

            SurfTestTheme {
                Scaffold { paddingValues ->
                    NavigationGraph(navController = navController)
                }
            }
        }
    }
}