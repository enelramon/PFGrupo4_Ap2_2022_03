package edu.ucne.quantumswap.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: Destinations("Home", "Home", Icons.Filled.Home)
    object LoginScreen: Destinations("LoginScreen", "Login", Icons.Filled.Person)
    object ShoppingCart: Destinations("ShoppingCart","Shopping Cart", Icons.Default.ShoppingCart)
}
