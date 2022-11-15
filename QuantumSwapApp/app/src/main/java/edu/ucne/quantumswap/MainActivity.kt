package edu.ucne.quantumswap

import android.annotation.SuppressLint
import android.graphics.drawable.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.ucne.quantumswap.ui.Home.HomeScreen
import edu.ucne.quantumswap.ui.theme.QuantumSwapTheme
import edu.ucne.quantumswap.R

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuantumSwapTheme {
                Scaffold (
                    topBar = {CenterAlignedTopAppBar(title = {Text("Quantum Swap")})
                    },
                ){
                    HomeScreen()
                }
            }
        }
    }
}

