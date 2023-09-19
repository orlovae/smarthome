package ru.alexandrorlov.smarthome.ui.component.tabs

import androidx.annotation.StringRes
import ru.alexandrorlov.smarthome.R
import ru.alexandrorlov.smarthome.config.Ui.CAMERAS
import ru.alexandrorlov.smarthome.config.Ui.DOORS

sealed class TabNavItem(
    val screenRoot: String,
    @StringRes val titleId: Int
) {
    object Cameras : TabNavItem(
        screenRoot = CAMERAS,
        titleId = R.string.cameras
    )
    object Doors : TabNavItem(
        screenRoot = DOORS,
        titleId = R.string.doors
    )
}
