package edu.ucne.quantumswap.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.ucne.quantumswap.ui.login.login
import edu.ucne.quantumswap.ui.shoppingCart.shoppingCartMain
import edu.ucne.quantumswap.ui.store.storeScreen
import edu.ucne.quantumswap.ui.navigation.Destinations.*
import edu.ucne.quantumswap.ui.sign.signIn

@Composable
fun navigationHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Home.route){


        composable(Home.route){
            storeScreen(onClick = { navController.navigate(ShoppingCart.route) })
        }
        composable(LoginScreen.route){
            login(onClick = {navController.navigate(Home.route)})
        }
        composable(ShoppingCart.route){
            shoppingCartMain()
        }

        composable(SignInScreen.route){
            signIn(onClick = { navController.navigate(LoginScreen.route) })
        }

    }
}