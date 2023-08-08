package ru.alexandrorlov.surf_test.navigation

import androidx.navigation.NamedNavArgument

internal interface UiNavCommand {
    val arguments: List<NamedNavArgument>
    val destination: String
}