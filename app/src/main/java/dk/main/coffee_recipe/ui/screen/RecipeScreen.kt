package dk.main.coffee_recipe.ui.screen

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import dk.main.coffee_recipe.RecipeDetailActivity
import dk.main.coffee_recipe.backend.Repository
import dk.main.coffee_recipe.ui.components.recipe.RecipeItem

@Composable
fun RecipeScreen() {
    val context = LocalContext.current
    Column {
        Repository.getRecipes()
            .map {
                RecipeItem(type = it.type, beanCountry = it.beanCountry, ratio = it.ratio, time = it.time) {
                    val intent = Intent(context, RecipeDetailActivity::class.java).apply {
                        putExtra("type", it.type)
                        putExtra("beanCountry", it.beanCountry)
                        putExtra("ratio", it.ratio)
                        putExtra("time", it.time)
                    }
                    context.startActivity(intent)
                }
            }
    }
}