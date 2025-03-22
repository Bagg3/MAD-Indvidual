package dk.main.coffee_recipe.backend.model

data class Recipe(
    val type: String,
    val beanCountry: String,
    val ratio: String,
    val time: String,
    val description: String,
    val difficulty: String,
    val ingredients: List<String>,
    val preparationSteps: List<String>
)