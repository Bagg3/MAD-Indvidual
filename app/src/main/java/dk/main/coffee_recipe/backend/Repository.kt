package dk.main.coffee_recipe.backend

import android.util.Log
import com.example.coffeerecipe.R
import dk.main.coffee_recipe.backend.model.Recipe

object Repository {
    private val recipes = listOf(
        Recipe(
            "Espresso",
            "Kenya",
            "1:2",
            "25s",
            "A concentrated coffee served in small, strong shots - the foundation of many coffee drinks.",
            "Medium",
            listOf("18g fine coffee grounds", "36g water"),
            listOf("Heat machine", "Grind coffee", "Extract for 25 seconds")
        ),
        Recipe(
            "Cappuccino",
            "Rwanda",
            "1:3",
            "30s",
            "A classic Italian coffee drink with equal parts espresso, steamed milk, and milk foam.",
            "Medium",
            listOf("18g coffee grounds", "60ml steamed milk", "60ml milk foam"),
            listOf("Make espresso", "Steam milk", "Pour steamed milk", "Add milk foam")
        ),
        Recipe(
            "Latte",
            "Kenya",
            "1:4",
            "35s",
            "A coffee drink made with espresso and steamed milk, topped with a small layer of foam.",
            "Easy",
            listOf("18g coffee grounds", "150ml steamed milk", "Light foam"),
            listOf("Pull espresso shot", "Steam milk", "Pour milk over espresso")
        ),
        Recipe(
            "Americano",
            "Rwanda",
            "1:6",
            "40s",
            "Espresso diluted with hot water, similar strength to drip coffee but different flavor.",
            "Easy",
            listOf("18g coffee grounds", "120ml hot water"),
            listOf("Prepare espresso", "Add hot water to espresso")
        ),
        Recipe(
            "Mocha",
            "Kenya",
            "1:5",
            "45s",
            "A chocolate-flavored variant of a latte, combining espresso, steamed milk and chocolate.",
            "Medium",
            listOf(
                "18g coffee grounds",
                "120ml steamed milk",
                "15g chocolate syrup",
                "Whipped cream"
            ),
            listOf(
                "Make espresso",
                "Add chocolate syrup",
                "Pour steamed milk",
                "Top with whipped cream"
            )
        )
    )

    fun getRecipes(): List<Recipe> {
        Log.v(this::class.simpleName, "Get Recipe List")
        return recipes.toList()
    }

    fun getRecipe(type: String?): Recipe? {
        Log.v(this::class.simpleName, "Get recipe for $type")
        return recipes.find { it.type == type }
    }
}