package edu.ucne.quantumswap.ui.shoppingCart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import edu.ucne.quantumswap.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontWeight
import edu.ucne.quantumswap.data.local.entity.Product



@Preview(showSystemUi = true)
@Composable
fun shoppingCartMain(
    viewModel: ShoppingCartViewModel = hiltViewModel()
) {
    val mainButtonColor = ButtonDefaults.buttonColors(
        containerColor = Color(0,0,0),
        contentColor = Color.White
    )

    val uiState by viewModel.uiSate.collectAsState()

    var cantidad = uiState.product.count()
    var Total = uiState.product.sumOf { it.Payment }

    Scaffold(
        bottomBar = {
            BottomAppBar(
               backgroundColor = Color.White,
                elevation = 25.dp
            ) {

                Button(
                    modifier = Modifier
                        .background(Color.Blue)
                        .height(40.dp)
                        .width(150.dp)
                    ,
                    shape = RoundedCornerShape(10),
                   colors = mainButtonColor,
                    onClick = { }
                ) {
                    Text(
                        text = "Comprar(${cantidad})",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Text(
                    text = "Full Payment:${Total}",
                    modifier = Modifier.padding(start = 60.dp),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    ) {
        Column {

            ShoppingCart(
                product = uiState.product
            )

        }
    }
}

@Composable
fun ShoppingCart(
    product: List<Product>,
    viewModel: ShoppingCartViewModel = hiltViewModel()
) {

    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(product){Product ->


            Card(
                elevation = 16.dp,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(top = 10.dp, start = 3.dp)) {

                    Row(modifier = Modifier.padding(0.dp, 0.dp)) {


                        Box(modifier = Modifier
                            .padding(0.dp)
                            .width(120.dp)
                            .height(120.dp)
                        ){
                            AsyncImage(
                                model = Product.Image,
                                contentDescription = "${Product.Image}"
                            )
                        }

                        Row(modifier = Modifier.padding(10.dp)) {
                            Box(modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .border(0.5.dp, Color.Blue)
                            ){

                                IconButton(onClick = {
                                    viewModel.ElimCant(
                                        Product.ProductId,
                                        Product.Description,
                                        Product.Price,
                                        Product.Image,
                                        Product.Cantidad - 1,
                                        Product.Payment
                                    )
                                })
                                {
                                    Image(painterResource(R.drawable.ic_baseline_horizontal_rule_24), contentDescription = "")
                                }

                            }

                            Box(
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp)
                                    .border(0.5.dp, Color.Blue)
                            ){

                                IconButton(onClick = {  }) {
                                    Text(
                                        text = "${Product.Cantidad}",
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                }

                            }
                            Box(modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .border(0.5.dp, Color.Blue)
                            ){

                                IconButton(onClick = {
                                    viewModel.AggCant(
                                        Product.ProductId,
                                        Product.Description,
                                        Product.Price,
                                        Product.Image,
                                        Product.Cantidad + 1,
                                        Product.Payment
                                    )
                                }
                                ) {
                                    Image(painterResource(R.drawable.ic_baseline_add_24), contentDescription = "")
                                }

                            }

                            Box(modifier = Modifier
                                .padding(15.dp)
                                .width(300.dp)
                                .height(20.dp)
                            ){

                                Text(
                                    text = "$ ${Product.Payment}",
                                    style = MaterialTheme.typography.titleMedium
                                )

                            }
                        }

                    }

                    IconButton(
                        onClick = { viewModel.Delete(Product) },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(text = "Remover")
                    }
                }

            }

        }

    }

    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp)
            .border(1.dp, Color.Black),
        color = Color.White
    )

}


