package edu.ucne.quantumswap.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: Destinations("Home", "Home", Icons.Filled.Home)
    object LoginScreen: Destinations("Login", "Login", Icons.Filled.Person)
    object ShoppingCart: Destinations("ShoppingCart","Shopping Cart", Icons.Default.ShoppingCart)
    object  SignInScreen: Destinations("SignIn", "Sign In", Icons.Default.AccountBox)
}
