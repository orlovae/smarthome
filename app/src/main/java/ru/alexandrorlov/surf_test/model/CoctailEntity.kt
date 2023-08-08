package ru.alexandrorlov.surf_test.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.alexandrorlov.surf_test.config.DataLocal

@Entity(tableName = DataLocal.Cocktail.TABLE_NAME)
data class CocktailEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DataLocal.Cocktail.COLUMN_ID)
    val id: Int,
    @ColumnInfo(name = DataLocal.Cocktail.COLUMN_URL_THUMB)
    val urlThumb: String? = null,
    @ColumnInfo(name = DataLocal.Cocktail.COLUMN_TITLE)
    val title: String,
    @ColumnInfo(name = DataLocal.Cocktail.COLUMN_DESCRIPTION)
    val description: String? = null,
    @ColumnInfo(name = DataLocal.Cocktail.COLUMN_RECIPE)
    val recipe: String? = null,
    @ColumnInfo(name = DataLocal.Cocktail.COLUMN_INGREDIENTS)
    val ingredients: List<String>? = null,
)