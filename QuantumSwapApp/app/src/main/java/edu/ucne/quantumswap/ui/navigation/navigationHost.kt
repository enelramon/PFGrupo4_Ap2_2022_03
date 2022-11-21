package edu.ucne.quantumswap.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.ucne.quantumswap.ui.login.Login
import edu.ucne.quantumswap.ui.ShoppingCart.ShoppingCartMain
import edu.ucne.quantumswap.ui.Store.StoreScreen
import edu.ucne.quantumswap.ui.navigation.Destinations.*
import edu.ucne.quantumswap.ui.sign.SignIn

@Composable
fun navigationHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Home.route){
        composable(Home.route){
            StoreScreen(onClick = { navController.navigate(ShoppingCart.route) })
        }
        composable(LoginScreen.route){
            Login(onClick = {navController.navigate(Home.route)})
        }
        composable(ShoppingCart.route){
            ShoppingCartMain()
        }

        composable(SignInScreen.route){
            SignIn(onClick = { navController.navigate(LoginScreen.route) })
        }
    }
}