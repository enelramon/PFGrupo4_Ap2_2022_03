package edu.ucne.quantumswap.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.ucne.quantumswap.ui.Home.HomeScreen
import edu.ucne.quantumswap.ui.Login.Login
import edu.ucne.quantumswap.ui.navigation.Destinations.*

@Composable
fun navigationHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Home.route){
        composable(Home.route){
           HomeScreen()
        }
        composable(LoginScreen.route){
            Login()
        }
    }
}