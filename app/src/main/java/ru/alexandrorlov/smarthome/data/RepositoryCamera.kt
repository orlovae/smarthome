package ru.alexandrorlov.smarthome.data

import kotlinx.coroutines.flow.Flow
import ru.alexandrorlov.smarthome.model.ui.CameraUi

interface RepositoryCamera {
    fun  getAllCameras() : Flow<List<CameraUi>>
    suspend fun fetchData()
}