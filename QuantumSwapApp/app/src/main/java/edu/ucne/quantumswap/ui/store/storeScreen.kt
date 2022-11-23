package edu.ucne.quantumswap.ui.store

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.compose.material3.Card

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import edu.ucne.quantumswap.data.remote.Dto.ProductDto
import edu.ucne.quantumswap.ui.components.splash

@OptIn( ExperimentalMaterial3Api::class)
@Composable
fun storeScreen(
    viewModel: StoreViewModel = hiltViewModel(),
    onClick: () -> Unit,
){
    Scaffold {
        val state = viewModel.state.value

        if(state.isLoading){
            splash()
//            CircularProgressIndicator()
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                items(state.products){ product ->
                    Box(modifier = Modifier
                        .fillMaxWidth(0.90f)
                        .padding(16.dp)
                    ){
                        ImageCard(
                            painter = rememberAsyncImagePainter(product.Image, contentScale = ContentScale.FillHeight),
                            contentDescription = product.Description,
                            title = product.Description,
                            product = product,
                            viewModel = viewModel,
                            onClick = onClick
                        )

                    }

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp),
                        color = Color.White
                    )


                }
            }

        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier,
    product: ProductDto,
    viewModel: StoreViewModel,
    onClick: () -> Unit
){

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp

    ){
        Box(modifier = Modifier
            .height(200.dp)
            .fillMaxSize()){
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp ))
            }
        }

    }
    Button(
        shape = RoundedCornerShape(15.dp),
        onClick = {
            viewModel.AddShoppingCart(
                product.ProductId,
                product.Description,
                product.Price,
                product.Image
            )
            onClick()
        },
        colors = ButtonDefaults.buttonColors(Color.Black),
        modifier = Modifier.height(38.dp)
    ) {
        Icon(
            modifier = Modifier.background(Color.Black),
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Add ShoppingCart",
            tint = Color.White
        )
    }

}




