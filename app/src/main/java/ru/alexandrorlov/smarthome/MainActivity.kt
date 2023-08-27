package ru.alexandrorlov.smarthome

import android.os.Bundle
import android.util.Log
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
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.alexandrorlov.smarthome.model.remote.camera.CamerasApi
import ru.alexandrorlov.smarthome.model.toRealmCamera
import ru.alexandrorlov.smarthome.data.local.Realm
import ru.alexandrorlov.smarthome.data.remote.NetworkClient
import ru.alexandrorlov.smarthome.ui.theme.SmarthomeTheme

class MainActivity : ComponentActivity() {
    private val apiService by lazy {
        NetworkClient.create()
    }

    private val database by lazy {
        Realm.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch {
            val result = apiService.getCameras()
            var cameras = CamerasApi(success = null, dataRemote = null)
            if (result is Result.Success) {
                cameras = result.data as CamerasApi
            }


            var cameraToRealm = database.getAllCameraEntity()

            if (cameras.dataRemote?.cameraRemotes != null && cameraToRealm.isEmpty()) {
                cameras.dataRemote.let { data ->
                    data?.cameraRemotes?.forEach {
                        database.addCameraEntity(it.toRealmCamera())
                    }

                }
            }

            Log.d("OAE", "${database.getAllCameraEntity()}")
        }

        setContent {
            SmarthomeTheme {
                // A surface container using the 'background' color from the theme

                val products = produceState(
                    initialValue = CamerasApi(success = null, dataRemote = null),
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
            CamerasApi(success = null, dataRemote = null)
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