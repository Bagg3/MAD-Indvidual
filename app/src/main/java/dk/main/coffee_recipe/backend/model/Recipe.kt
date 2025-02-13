package dk.main.coffee_recipe.backend.model

data class Recipe(
    val type: String,
    val beanCountry: String,
    val ratio: String,
    val time: String
)