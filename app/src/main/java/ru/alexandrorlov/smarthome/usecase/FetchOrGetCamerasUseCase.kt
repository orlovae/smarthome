package ru.alexandrorlov.smarthome.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.alexandrorlov.smarthome.data.RepositoryCamera
import ru.alexandrorlov.smarthome.model.ui.CameraUi
import ru.alexandrorlov.smarthome.util.NetworkHelper
import javax.inject.Inject

class FetchOrGetCamerasUseCase @Inject constructor(
    private val repository: RepositoryCamera,
    private val networkHelper: NetworkHelper
) {
    suspend fun execute(): Flow<List<CameraUi>> = flow {
        if (networkHelper.isConnect()) {
            repository.fetchData()
        }
        repository.getAllCameras().collect { list ->
            emit(list)
        }
    }.flowOn(Dispatchers.IO)
}