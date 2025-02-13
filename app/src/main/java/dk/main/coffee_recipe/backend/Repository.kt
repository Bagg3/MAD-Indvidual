package dk.main.coffee_recipe.backend

import android.util.Log
import dk.main.coffee_recipe.backend.model.Recipe

object Repository {
    private val recipes = listOf(
        Recipe(
            "Espresso",
            "Kenya",
            "1:2",
            "25s"
        ),
        Recipe(
            "Cappuccino",
            "Rwanda",
            "1:3",
            "30s"
        ),
        Recipe(
            "Latte",
            "Kenya",
            "1:4",
            "35s"
        ),
        Recipe(
            "Americano",
            "Rwanda",
            "1:6",
            "40s"
        ),
        Recipe(
            "Mocha",
            "Kenya",
            "1:5",
            "45s"
        )
    )


    fun getRecipes(): List<Recipe> {
        Log.v(this::class.simpleName, "Get VacationList")
        return recipes.map { Recipe(it.type, it.beanCountry, it.ratio, it.time) }
    }

    fun getRecipe(type: String?): Recipe? {
        Log.v(this::class.simpleName, "Get recipe for $type")
        return recipes.find { it.type == type }
    }
}