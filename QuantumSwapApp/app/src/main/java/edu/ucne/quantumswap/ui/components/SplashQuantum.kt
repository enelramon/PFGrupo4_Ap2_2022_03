package edu.ucne.quantumswap.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import edu.ucne.quantumswap.ui.navigation.Destinations
import kotlinx.coroutines.delay

@Composable
fun SplashQuantum(
    navHostController: NavHostController
) {

    LaunchedEffect(key1 = true){
        delay(6000)
        navHostController.popBackStack()
        navHostController.navigate(Destinations.Home.route)
    }
    Splash()

}