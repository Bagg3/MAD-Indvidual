package dk.main.coffee_recipe

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.coffeerecipe.R
import dk.main.coffee_recipe.ui.components.Menu
import dk.main.coffee_recipe.model.MenuItemModel
import dk.main.coffee_recipe.ui.theme.CoffeeRecipeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeRecipeTheme {
                val menuItemModels = listOf(MenuItemModel(
                    "Coffee Recipe",
                    ImageVector.vectorResource(id = R.drawable.baseline_sunny_24)
                ) {
                    val intent = Intent(this, RecipesActivity::class.java)
                    startActivity(intent)
                })

                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Menu(title = "MyApp", menuItemModels) {

                        }
                    }

                }
            }

        }
    }
}

