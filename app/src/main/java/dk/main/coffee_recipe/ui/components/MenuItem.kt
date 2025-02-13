package dk.main.coffee_recipe.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dk.main.coffee_recipe.model.MenuItemModel

@Composable
fun MenuItem(model: MenuItemModel) {
    NavigationDrawerItem(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(model.title) },
        icon = {
            Icon(
                imageVector = model.imageVector,
                "contentDescription",
                tint = MaterialTheme.colorScheme.onSurface
            )
        },
        selected = false,
        onClick = model.action
    )
}

@Preview
@Composable
fun MenuItemPreview() {
    val model = MenuItemModel("TEST",  Icons.Default.Call) {
    }
    MenuItem(model = model)
}