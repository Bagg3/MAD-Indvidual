package dk.main.coffee_recipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dk.main.coffee_recipe.ui.screen.RecipeDetailScreen
import dk.main.coffee_recipe.ui.theme.CoffeeRecipeTheme

class RecipeDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = intent.getStringExtra("type")

        setContent {
            CoffeeRecipeTheme {
                RecipeDetailScreen(type)
            }
        }
    }
}

