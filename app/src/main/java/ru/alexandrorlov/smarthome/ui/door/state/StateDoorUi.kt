package ru.alexandrorlov.smarthome.ui.door.state

import ru.alexandrorlov.smarthome.base.UiState

data class StateDoorUi(
    val stateDoor: StateDoor = StateDoor.Loading
) : UiState
