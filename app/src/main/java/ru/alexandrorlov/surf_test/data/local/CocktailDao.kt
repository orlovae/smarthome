package ru.alexandrorlov.surf_test.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.alexandrorlov.surf_test.config.DataLocal
import ru.alexandrorlov.surf_test.model.CocktailEntity

@Dao
interface CocktailDao {
    @Query("SELECT * FROM ${DataLocal.Cocktail.TABLE_NAME} WHERE id=:id ")
    suspend fun getCocktailById(id: Int): CocktailEntity

    @Query("SELECT * FROM ${DataLocal.Cocktail.TABLE_NAME}")
    suspend fun getAll(): List<CocktailEntity>

    @Update
    suspend fun update(mealEntity: CocktailEntity)

    @Insert
    suspend fun insertAll(mealEntityList: List<CocktailEntity>)

    @Query("DELETE FROM ${DataLocal.Cocktail.TABLE_NAME}")
    suspend fun deleteAll()
}