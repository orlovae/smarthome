package ru.alexandrorlov.smarthome.data.remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import ru.alexandrorlov.smarthome.config.RemoteConfig.QUERY_PARAMETER_CAMERAS
import ru.alexandrorlov.smarthome.model.remote.camera.CameraRemote
import ru.alexandrorlov.smarthome.model.remote.camera.CamerasApi
import javax.inject.Inject

class RepositoryRemoteCameraImpl @Inject constructor(
    private val client: HttpClient
) : ApiCamera {
    override suspend fun getCameras(): List<CameraRemote> {
        return try {
            client.get(QUERY_PARAMETER_CAMERAS).body<CamerasApi>().dataRemote?.cameraRemotes
                ?: emptyList()
        } catch (ex: Exception) {
            emptyList()
        }
    }
}