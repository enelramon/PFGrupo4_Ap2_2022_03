package edu.ucne.quantumswap.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ScaffoldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.ucne.quantumswap.R
import edu.ucne.quantumswap.ui.navigation.Destinations
import edu.ucne.quantumswap.ui.navigation.currentRoute
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun drawer(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController,
    items: List<Destinations>
){
    Column{
//        Image(
//            painter = painterResource(id = R.drawable.bg),
//            contentDescription = "Bg Image",
//            modifier = Modifier
//                .height(160.dp)
//                .fillMaxWidth(),
//            contentScale = ContentScale.FillWidth
//        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp))

        val currentRoute = currentRoute(navController)
        items.forEach { item ->
            drawerItem(item = item, selected = currentRoute == item.route) {
                navController.navigate(item.route) {
                    launchSingleTop = true
                }

                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }
        }
    }
}

@Composable
fun drawerItem(
    item: Destinations,
    selected: Boolean,
    onItemClick: (Destinations) -> Unit
){
    Row(
        modifier = Modifier
            .shadow(13.dp)
            .fillMaxWidth()
            .height(56.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(12))
            .background(if (selected) Color(0.153f, 0.153f, 0.153f, 1.0f) else Color.Transparent)
            .padding(8.dp)
            .clickable { onItemClick(item) },
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = item.icon,
            contentDescription = item.title,
            tint = if(selected) Color.White else Color.Black
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = item.title,
            fontSize = 18.sp,
            color = if(selected) Color.White else Color.Black
        )
    }
}