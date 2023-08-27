package ru.alexandrorlov.smarthome.model.remote.door

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DoorRemote(
    @SerialName("name")
    val name: String,
    @SerialName("room")
    val room: String?,
    @SerialName("id")
    val id: Int,
    @SerialName("favorites")
    val favorites: Boolean,
    @SerialName("snapshot")
    val snapshot: String? = null
)