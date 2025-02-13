package dk.main.coffee_recipe.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dk.main.coffee_recipe.backend.Repository

@Composable
fun RecipeDetailScreen(type: String?) {
    Column {
       Repository.getRecipe(type)
           ?.let {
               Text(text = "Type: ${it.type}")
               Text(text = "Bean Country: ${it.beanCountry}")
               Text(text = "Ratio: ${it.ratio}")
               Text(text = "Time: ${it.time}")
           }
    }
}