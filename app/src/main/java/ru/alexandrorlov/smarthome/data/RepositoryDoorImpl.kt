package ru.alexandrorlov.smarthome.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.alexandrorlov.smarthome.data.local.DatabaseDoor
import ru.alexandrorlov.smarthome.data.remote.ApiDoor
import ru.alexandrorlov.smarthome.model.toDoorUi
import ru.alexandrorlov.smarthome.model.toRealmDoor
import ru.alexandrorlov.smarthome.model.ui.DoorUi
import javax.inject.Inject

class RepositoryDoorImpl @Inject constructor(
    private val remote: ApiDoor,
    private val local: DatabaseDoor
) : RepositoryDoor {

    override fun getAllDoors(): Flow<List<DoorUi>> = flow {
        val listDoorEntity = local.getAllDoorEntity()
        emit(listDoorEntity.map { it.toDoorUi() })
    }.flowOn(Dispatchers.IO)

    override suspend fun fetchData() {
        val listRemote = remote.getDoors()

        if (listRemote.isNotEmpty()) {
            local.clearDoorEntity()
            listRemote.forEach { doorRemote ->
                local.addDoorEntity(doorRemote.toRealmDoor())
            }
        }
    }
}