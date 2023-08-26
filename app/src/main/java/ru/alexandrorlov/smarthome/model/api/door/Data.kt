package ru.alexandrorlov.smarthome.model.api.door

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("name")
    val name: String,
    @SerialName("room")
    val room: String?,
    @SerialName("id")
    val id: Int,
    @SerialName("favorites")
    val favorites: Boolean,
    @SerialName("snapshot")
    val snapshot: String?
)