package ru.alexandrorlov.surf_test.base

import ru.alexandrorlov.surf_test.model.CocktailEntity
import ru.alexandrorlov.surf_test.model.CocktailUi

fun List<CocktailUi>.toListCocktailEntity(): List<CocktailEntity> {
    return this.map { cocktailUi ->
        cocktailUi.toCocktailEntity()
    }
}

fun CocktailUi.toCocktailEntity(): CocktailEntity {
    return CocktailEntity(
        id = this.id,
        urlThumb = this.urlThumb,
        title = this.title,
        description = this.description,
        recipe = this.recipe,
        ingredients = this.ingredients
    )
}