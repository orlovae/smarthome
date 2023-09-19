package ru.alexandrorlov.smarthome.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.alexandrorlov.smarthome.data.local.DatabaseCamera
import ru.alexandrorlov.smarthome.data.remote.ApiCamera
import ru.alexandrorlov.smarthome.model.toCameraUi
import ru.alexandrorlov.smarthome.model.toRealmCamera
import ru.alexandrorlov.smarthome.model.ui.CameraUi


class RepositoryCameraImpl constructor(
    private val remote: ApiCamera,
    private val local: DatabaseCamera
) : RepositoryCamera {
    override fun getAllCameras(): Flow<List<CameraUi>> = flow {
        val listCameraEntity = local.getAllCameraEntity()
        emit(listCameraEntity.map { it.toCameraUi() })
    }.flowOn(Dispatchers.IO)

    override suspend fun fetchData() {
        val listRemote = remote.getCameras()

        if (listRemote.isNotEmpty()) {
            local.clearCameraEntity()
            listRemote.forEach { cameraRemote ->
                local.addCameraEntity(cameraRemote.toRealmCamera())
            }
        }
    }
}