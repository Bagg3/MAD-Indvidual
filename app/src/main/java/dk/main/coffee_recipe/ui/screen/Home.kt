package dk.main.coffee_recipe.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeerecipe.R
import dk.main.coffee_recipe.ui.theme.CoffeeRecipeTheme

@Composable
fun Home() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.drawable.coffee_recipe_pic),
                contentDescription = "Coffee Recipe"
            )
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    CoffeeRecipeTheme {
        Home()
    }
}