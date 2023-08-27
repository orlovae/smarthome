package ru.alexandrorlov.smarthome.data

import kotlinx.coroutines.flow.Flow
import ru.alexandrorlov.smarthome.model.ui.CameraUi
import ru.alexandrorlov.smarthome.model.ui.DoorUi
import ru.alexandrorlov.smarthome.data.local.Database
import ru.alexandrorlov.smarthome.data.remote.ApiService

class RepositoryImpl constructor(
    private val remote: ApiService,
    private val local: Database
) : Repository {

    override suspend fun getAllCameraUi(): Flow<CameraUi> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllDoorUi(): Flow<DoorUi> {
        TODO("Not yet implemented")
    }
}