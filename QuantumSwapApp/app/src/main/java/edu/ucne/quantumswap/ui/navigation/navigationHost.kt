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
            storeScreen { navController.navigate(ShoppingCart.route) }
        }

//        composable(Home.route){
//            storeScreen(onClick = { Price ->
//                navController.navigate(ShoppingCart.route +
//                "/$Price"
//                )
//            })
//        }
        composable(ShoppingCart.route){
            shoppingCartMain()
        }

//        composable(
//            ShoppingCart.route + "/{Price}",
//            arguments = listOf(navArgument("Price"){type = NavType.IntType})
//        )
//        {navBackStackEntry ->
//            val Price = navBackStackEntry.arguments?.getInt("Price") ?: 0
//            shoppingCartMain(Price)
//        }


        composable(LoginScreen.route){
            login(onClick = {navController.navigate(Home.route)})
        }


        composable(SignInScreen.route){
            signIn(onClick = { navController.navigate(LoginScreen.route) })
        }

    }
}