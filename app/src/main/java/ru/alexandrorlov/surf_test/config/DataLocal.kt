package ru.alexandrorlov.surf_test.config

object DataLocal {
    const val DATABASE_NAME = "cocktail.db"

    object Cocktail {
        const val TABLE_NAME = "Cocktails"
        const val COLUMN_ID = "id"
        const val COLUMN_URL_THUMB = "url_thumb"
        const val COLUMN_TITLE = "title"
        const val COLUMN_DESCRIPTION = "description"
        const val COLUMN_RECIPE = "recipe"
        const val COLUMN_INGREDIENTS = "ingredients"
    }
}