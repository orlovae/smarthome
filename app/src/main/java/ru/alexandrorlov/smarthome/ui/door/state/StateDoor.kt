package ru.alexandrorlov.smarthome.ui.door.state

import androidx.annotation.StringRes
import ru.alexandrorlov.smarthome.base.UiState
import ru.alexandrorlov.smarthome.model.ui.DoorUi

sealed class StateDoor : UiState {
    object Loading : StateDoor()
    data class Data(val doorList: List<DoorUi>) : StateDoor()

    val data: Data?
        get() = this as? Data

    data class Error(@StringRes val idMessage: Int) : StateDoor()
}