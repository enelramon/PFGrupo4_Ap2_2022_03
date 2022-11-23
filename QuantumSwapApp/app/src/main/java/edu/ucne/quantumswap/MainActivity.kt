package edu.ucne.quantumswap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.quantumswap.ui.components.drawer
import edu.ucne.quantumswap.ui.components.topBar
import edu.ucne.quantumswap.ui.navigation.Destinations
import edu.ucne.quantumswap.ui.navigation.navigationHost
import edu.ucne.quantumswap.ui.Home.HomeScreen
import edu.ucne.quantumswap.ui.theme.QuantumSwapTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MainScreen()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
){
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    )
    val scope = rememberCoroutineScope()
    val navigationItems = listOf(
        Destinations.Home,
        Destinations.LoginScreen,
        Destinations.SignInScreen
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { topBar(scope, scaffoldState, onClick = {
                if(navController.currentDestination?.route == Destinations.ShoppingCart.route) {

                    navController.navigate(Destinations.Home.route)

                }else{

                    navController.navigate(Destinations.ShoppingCart.route)

                }
            })
         },
        drawerContent = { drawer(scope, scaffoldState, navController, items = navigationItems) },
        drawerGesturesEnabled = true
    ) {
        navigationHost(navController)
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuantumSwapTheme {
        Greeting("Android")
    }
}