package ru.alexandrorlov.smarthome.data.remote

import ru.alexandrorlov.smarthome.model.remote.door.DoorRemote

interface ApiDoor {
    suspend fun getDoors(): List<DoorRemote>
}