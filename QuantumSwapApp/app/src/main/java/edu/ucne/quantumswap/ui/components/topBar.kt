package edu.ucne.quantumswap.ui.components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import edu.ucne.quantumswap.ui.navigation.Destinations
import edu.ucne.quantumswap.ui.navigation.navigationHost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    onClick: () ->Unit,
){
    CenterAlignedTopAppBar(
        title = { Text("Quantum Swap") },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Icon")
            }
        },

        actions = {
            if (true){

                IconButton(onClick =  onClick) {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "ShoppingCart"
                    )
            }
        }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Account"
                )
            }


        }
    )
}