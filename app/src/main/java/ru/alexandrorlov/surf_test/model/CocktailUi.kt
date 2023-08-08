package ru.alexandrorlov.surf_test.model

data class CocktailUi(
    val id: Int,
    val urlThumb: String? = null,
    val title: String,
    val description: String? = null,
    val recipe: String? = null,
    val ingredients: List<String>? = null,
)