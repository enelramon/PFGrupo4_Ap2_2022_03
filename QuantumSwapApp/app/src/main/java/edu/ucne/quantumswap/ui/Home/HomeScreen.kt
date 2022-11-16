package edu.ucne.quantumswap.ui.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import edu.ucne.quantumswap.R

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.padding(60.dp)) {
            Image(painterResource(R.drawable.logo), contentDescription = "")
        }

        Text(
            text = "Bienvenido a Quantum Swap",
            modifier = Modifier.padding(40.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "La tienda descentralizada mas completa de la web Quantum Swap te permite comprar y vender articulos usando cripto monedas.",
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleSmall
        )

    }
}



