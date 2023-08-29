package ru.alexandrorlov.smarthome.data

import kotlinx.coroutines.flow.Flow
import ru.alexandrorlov.smarthome.model.ui.DoorUi

interface RepositoryDoor {
    fun getAllDoors(): Flow<List<DoorUi>>
    suspend fun fetchData()
}