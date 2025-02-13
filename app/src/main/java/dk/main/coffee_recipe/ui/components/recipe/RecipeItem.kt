package dk.main.coffee_recipe.ui.components.recipe

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dk.main.coffee_recipe.ui.theme.CoffeeRecipeTheme


@Composable
fun RecipeItem(type: String, beanCountry: String, ratio: String, time: String, goToRecipe: () -> Unit) {
    Box() {
        Row(
            Modifier
                .padding(all = 5.dp)
                .background(MaterialTheme.colorScheme.primary)
                .clickable {
                    goToRecipe()
                }) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth()
                    .padding(5.dp),
                text = type,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview
@Composable
fun PreviewVacationItem() {
    CoffeeRecipeTheme (darkTheme = true) {
        RecipeItem("Espresso", "Columbia", "1:2", "30s") {
        }
    }
}
