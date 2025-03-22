package dk.main.coffee_recipe.ui.components.recipe

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun RecipeItem(
    type: String,
    beanCountry: String,
    ratio: String,
    time: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = type,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Origin: $beanCountry",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Ratio: $ratio",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Brew time: $time",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

