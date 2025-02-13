package dk.main.coffee_recipe.model

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItemModel(
    val title: String,
    val imageVector: ImageVector,
    val action: () -> Unit
)