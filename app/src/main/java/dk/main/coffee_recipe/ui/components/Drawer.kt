package dk.main.coffee_recipe.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeerecipe.R
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
                drawerContainerColor = MaterialTheme.colorScheme.surface,
                drawerContentColor = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.width(280.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    menuItemModels.forEachIndexed { index, item ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            MenuItem(
                                model = item.copy(
                                    action = {
                                        scope.launch {
                                            item.action()
                                            drawerState.close()
                                        }
                                    }
                                )
                            )
                        }

                        // Add a divider between menu items if it's not the last item
                        if (index < menuItemModels.size - 1) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Divider(
                                modifier = Modifier.padding(vertical = 4.dp),
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

            }
        },
        drawerState = drawerState,
        gesturesEnabled = true,
        scrimColor = Color.Black.copy(alpha = 0.5f),
        content = content
    )
}

@Preview
@Composable
fun DrawerPreview() {
    CoffeeRecipeTheme(darkTheme = true) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
        val menuItemModels = listOf(
            MenuItemModel("Coffee Recipes", Icons.Default.Home) {},
            MenuItemModel("Favorites", Icons.Default.Star) {},
            MenuItemModel("Settings", Icons.Default.Settings) {}
        )
        Drawer(menuItemModels, drawerState) {
            Button(onClick = { }) {
                Text("Content")
            }
        }
    }
}