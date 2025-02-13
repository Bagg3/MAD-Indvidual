package dk.main.coffee_recipe.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import dk.main.coffee_recipe.model.MenuItemModel
import dk.main.coffee_recipe.ui.components.Drawer
import dk.main.coffee_recipe.ui.components.MenuBar
import kotlinx.coroutines.launch

@Composable
fun Menu(
    title: String,
    menuItemModels: List<MenuItemModel>,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    Column {
        MenuBar(title = title, modifier) {
            scope.launch {
                drawerState.open()
            }
        }
        Drawer(menuItemModels, drawerState = drawerState, content)
    }
}