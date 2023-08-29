package ru.alexandrorlov.smarthome.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.alexandrorlov.smarthome.data.RepositoryDoor
import ru.alexandrorlov.smarthome.model.ui.DoorUi
import ru.alexandrorlov.smarthome.util.NetworkHelper
import javax.inject.Inject

class FetchOrGetDoorsUseCase @Inject constructor(
    private val repository: RepositoryDoor,
    private val networkHelper: NetworkHelper
) {
    suspend fun execute(): Flow<List<DoorUi>> = flow {
        if (networkHelper.isConnect()) {
            repository.fetchData()
        }
        repository.getAllDoors().collect { list ->
            emit(list)
        }
    }.flowOn(Dispatchers.IO)
}