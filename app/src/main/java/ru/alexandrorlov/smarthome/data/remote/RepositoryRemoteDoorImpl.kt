package ru.alexandrorlov.smarthome.data.remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import ru.alexandrorlov.smarthome.config.RemoteConfig
import ru.alexandrorlov.smarthome.model.remote.door.DoorRemote
import ru.alexandrorlov.smarthome.model.remote.door.DoorsApi
import javax.inject.Inject

class RepositoryRemoteDoorImpl @Inject constructor(
    private val client: HttpClient
) : ApiDoor {
    override suspend fun getDoors(): List<DoorRemote> {
        return try {
            client.get(RemoteConfig.QUERY_PARAMETER_DOORS).body<DoorsApi>().data
        } catch (ex: Exception) {
            emptyList()
        }
    }
}