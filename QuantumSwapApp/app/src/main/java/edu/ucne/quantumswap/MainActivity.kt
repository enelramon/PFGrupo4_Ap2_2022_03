package edu.ucne.quantumswap

import android.annotation.SuppressLint
import android.graphics.drawable.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import edu.ucne.quantumswap.ui.components.drawer
import edu.ucne.quantumswap.ui.components.topBar
import edu.ucne.quantumswap.ui.navigation.Destinations
import edu.ucne.quantumswap.ui.navigation.navigationHost
import edu.ucne.quantumswap.ui.Home.HomeScreen
import edu.ucne.quantumswap.ui.Login.Login
import edu.ucne.quantumswap.ui.theme.QuantumSwapTheme
import edu.ucne.quantumswap.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
//            QuantumSwapTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
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
        Destinations.LoginScreen
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { topBar(scope, scaffoldState) },
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