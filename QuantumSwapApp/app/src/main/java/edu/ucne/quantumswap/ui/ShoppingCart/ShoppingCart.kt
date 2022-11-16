package edu.ucne.quantumswap.ui.ShoppingCart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import edu.ucne.quantumswap.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.material3.ElevatedButton
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Button
import androidx.compose.ui.text.font.FontWeight


@Preview(showSystemUi = true)
@Composable
fun ShoppingCartMain() {
    Scaffold(
    ) {
        Column() {
            ShoppingCart()
            Box(modifier = Modifier
                .padding(top = 0.dp)
                .fillMaxWidth()
                .height(80.dp)
            )
            {
                Text(
                    text = "Full Payment $50,000.00",
                    modifier = Modifier.padding(top = 20.dp, start = 260.dp),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold
                )

                val mainButtonColor = ButtonDefaults.buttonColors(
                    containerColor = Color(0,0,0),
                    contentColor = Color.White
                )

                Button(
                    modifier = Modifier
                        .padding(top = 20.dp, start = 20.dp)
                        .width(160.dp)
                    ,
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(10),
                    colors = mainButtonColor

                )
                {
                    Text(
                        text = "Comprar (1)",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}

@Composable
fun ShoppingCart() {

    Card(
        elevation = 16.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(5.dp)) {

            Row(modifier = Modifier.padding(0.dp, 5.dp)) {

                Box(modifier = Modifier
                    .padding(5.dp)
                    .width(120.dp)
                    .height(120.dp)
                    .background(Color.DarkGray)){
                    Image(painterResource(R.drawable.logo), contentDescription = "")
                }

                Row(modifier = Modifier.padding(20.dp)) {
                    Box(modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                        .border(0.5.dp, Color.Blue)
                    ){

                        IconButton(onClick = { /*TODO*/ }) {
                            Image(painterResource(R.drawable.ic_baseline_horizontal_rule_24), contentDescription = "")
                        }

                    }

                    Box(
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .border(0.5.dp, Color.Blue)
                    ){

                        IconButton(onClick = { /*TODO*/ }) {
                            Text(
                                text = "1",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                    }

                    Box(modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                        .border(0.5.dp, Color.Blue)
                    ){

                        IconButton(onClick = { /*TODO*/ }) {
                            Image(painterResource(R.drawable.ic_baseline_add_24), contentDescription = "")
                        }

                    }

                    Box(modifier = Modifier
                        .padding(20.dp)
                        .width(300.dp)
                        .height(20.dp)
                    ){

                        Text(
                            text = "$50,000",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }

            }

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Remover")
            }
        }

    }
}


