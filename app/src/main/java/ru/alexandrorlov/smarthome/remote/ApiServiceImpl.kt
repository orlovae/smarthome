package ru.alexandrorlov.smarthome.remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import ru.alexandrorlov.smarthome.Result
import ru.alexandrorlov.smarthome.config.RemoteConfig.QUERY_PARAMETER_CAMERAS
import ru.alexandrorlov.smarthome.config.RemoteConfig.QUERY_PARAMETER_DOORS
import ru.alexandrorlov.smarthome.model.api.camera.CamerasApi
import ru.alexandrorlov.smarthome.model.api.door.DoorsApi


class ApiServiceImpl(private val client: HttpClient) : ApiService {
    override suspend fun getCameras(): Result<Any> {
        return try {
            Result.Success(
                client.get(QUERY_PARAMETER_CAMERAS).body<CamerasApi>()
            )
        } catch (ex: RedirectResponseException) {
            // 3xx - responses
            Result.Error(ex.response.status.description)
        } catch (ex: ClientRequestException) {
            // 4xx - responses
            Result.Error(ex.response.status.description)
        } catch (ex: ServerResponseException) {
            // 5xx - response
            Result.Error(ex.response.status.description)
        }
    }

    override suspend fun getDoors(): Result<Any> {
        return try {
            Result.Success(
                client.get(QUERY_PARAMETER_DOORS).body<DoorsApi>()
            )
        } catch (ex: RedirectResponseException) {
            // 3xx - responses
            Result.Error(ex.response.status.description)
        } catch (ex: ClientRequestException) {
            // 4xx - responses
            Result.Error(ex.response.status.description)
        } catch (ex: ServerResponseException) {
            // 5xx - response
            Result.Error(ex.response.status.description)
        }
    }
}