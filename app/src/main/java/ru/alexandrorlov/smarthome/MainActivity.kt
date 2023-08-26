package ru.alexandrorlov.smarthome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.smarthome.model.api.camera.CamerasApi
import ru.alexandrorlov.smarthome.remote.NetworkClient
import ru.alexandrorlov.smarthome.ui.theme.SmarthomeTheme

class MainActivity : ComponentActivity() {
    private val apiService by lazy {
        NetworkClient.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            SmarthomeTheme {
                // A surface container using the 'background' color from the theme

                val products = produceState(
                    initialValue = CamerasApi(success = null, data = null),
                    producer = {
                        value = getCamerasApi()
                    }
                )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(products.value.toString())
                }
            }
        }
    }

    private suspend fun getCamerasApi(): CamerasApi {
        val result = apiService.getCameras()
        return if (result is Result.Success) {
            result.data as CamerasApi
        } else {
            CamerasApi(success = null, data = null)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = name)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SmarthomeTheme {
        Greeting("Android")
    }
}