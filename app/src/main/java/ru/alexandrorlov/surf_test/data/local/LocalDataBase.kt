package ru.alexandrorlov.surf_test.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.alexandrorlov.surf_test.model.CocktailEntity

@Database(entities = [CocktailEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class LocalDataBase : RoomDatabase() {

    abstract fun CocktailDao(): CocktailDao
}