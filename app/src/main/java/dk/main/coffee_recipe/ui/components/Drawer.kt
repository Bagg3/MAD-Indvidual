package dk.main.coffee_recipe.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import dk.main.coffee_recipe.model.MenuItemModel
import dk.main.coffee_recipe.ui.theme.CoffeeRecipeTheme
import kotlinx.coroutines.launch

@Composable
fun Drawer(
    menuItemModels: List<MenuItemModel>,
    drawerState: DrawerState,
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.onBackground,
                drawerContentColor = MaterialTheme.colorScheme.background
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    menuItemModels.map {
                        MenuItem(model = it.copy(action = {
                            scope.launch {
                                it.action()
                                drawerState.close()
                            }
                        }))
                    }
                }
            }
        }, modifier = Modifier,drawerState = drawerState, gesturesEnabled = true,
        scrimColor = Color.Red, content = content
    )
}


@Preview
@Composable
fun DrawerPreview() {
    CoffeeRecipeTheme(darkTheme = true) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val menuItemModels = listOf(
            MenuItemModel("Recipe",  Icons.Default.Home) {
            }
        )
        Drawer(menuItemModels, drawerState) {
            Button(onClick = { /*TODO*/ }) {
                Text("Content")
            }
        }
    }
}