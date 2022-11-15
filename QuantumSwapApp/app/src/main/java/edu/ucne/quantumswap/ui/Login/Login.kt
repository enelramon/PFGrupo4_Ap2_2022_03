package edu.ucne.quantumswap.ui.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf


import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.text.*
import androidx.compose.material3.Text


import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.ucne.quantumswap.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyIcon(modifier: Modifier =Modifier.padding(bottom = 30.dp))
{
    Column(modifier = Modifier.padding(2.dp)) {
        Image(painterResource(R.drawable.logo), contentDescription = "")
    }

}


@Composable
fun Login() {

    val mainButtonColor = ButtonDefaults.buttonColors(
        containerColor = androidx.compose.ui.graphics.Color(25,118,210),
        contentColor = Color.White
    )

    Column(
        modifier = Modifier

    ) {
        Column(Modifier.padding(100.dp)) {
            MyIcon(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(20.dp)
            )

        }
        Column (
            Modifier
                .padding(0.dp)
                .align(Alignment.CenterHorizontally)
        ){
            PintaTextfiel()
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(60.dp)
                .shadow(4.dp)
                .width(300.dp),
            onClick = {

            },shape = RoundedCornerShape(12), colors = mainButtonColor
        ){

            Text(text = "LOG IN")

        }

    }
}


@Composable
fun PintaTextfiel()
{
    OutlinedTextField(
        modifier = Modifier
            .height(60.dp)
            .width(300.dp),
        value = "",
        label = { Text(text = "Email Address*")},
        onValueChange = {""},
        shape = CutCornerShape(5),
    )
    Spacer(modifier = Modifier.padding(16.dp))
    OutlinedTextField(
        modifier = Modifier
            .height(60.dp)
            .width(300.dp),
        value = "",
        label = { Text(text = "Password*")},
        onValueChange = {""},
        shape = CutCornerShape(5),
    )
}

