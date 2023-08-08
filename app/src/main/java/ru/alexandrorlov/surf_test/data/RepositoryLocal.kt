package ru.alexandrorlov.surf_test.data

import ru.alexandrorlov.surf_test.base.toCocktailEntity
import ru.alexandrorlov.surf_test.base.toListCocktailEntity
import ru.alexandrorlov.surf_test.data.local.LocalDataBase
import ru.alexandrorlov.surf_test.model.CocktailEntity
import ru.alexandrorlov.surf_test.model.CocktailUi
import javax.inject.Inject

class RepositoryLocal @Inject constructor(
    private val dataBase: LocalDataBase
) {
    suspend fun getAllCocktailEntity(): List<CocktailEntity> {
        return dataBase.CocktailDao().getAll()
    }

    suspend fun getCocktailEntityById(id: Int): CocktailEntity {
        return dataBase.CocktailDao().getCocktailById(id)
    }

    suspend fun insertAllCocktailUi(listCocktailUi: List<CocktailUi>) {
        dataBase.CocktailDao().insertAll(
            listCocktailUi.toListCocktailEntity()
        )
    }

    suspend fun update(cocktailUi: CocktailUi) {
        dataBase.CocktailDao().update(
            cocktailUi.toCocktailEntity()
        )
    }

    suspend fun deleteAll() {
        dataBase.CocktailDao().deleteAll()
    }
}