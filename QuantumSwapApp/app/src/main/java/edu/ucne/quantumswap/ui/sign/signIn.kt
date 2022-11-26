package edu.ucne.quantumswap.ui.sign

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun signIn(
    onClick: () -> Unit,
    viewModel: SigInViewModel = hiltViewModel()
) {

    var context = LocalContext.current
    val  toast  = Toast.makeText(context, "Succes", Toast.LENGTH_LONG)


    Scaffold (

        topBar = {
            CenterAlignedTopAppBar(title = { Text("Sign In  Entry")})
        },

        ){

        Box(modifier = Modifier
            .padding(top = 50.dp)
        ){
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(5.dp))
            {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                    ,
                    value = viewModel.name,
                    onValueChange = { viewModel.name = it },
                    label = { Text(text = "Name")}
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    value = viewModel.lastname,
                    onValueChange = { viewModel.lastname = it },
                    label = { Text(text = "Last Name")}
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    value = viewModel.email,
                    onValueChange = { viewModel.email = it },
                    label = { Text(text = "Email")},

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    value = viewModel.password,
                    onValueChange = { viewModel.password = it },
                    label = { Text(text = "Password")},

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )
                )


                    val mainButtonColor = ButtonDefaults.buttonColors(
                        containerColor = androidx.compose.ui.graphics.Color(25,118,210),
                        contentColor = Color.White
                    )
                    Button(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .height(60.dp)
                            .shadow(4.dp)
                            .width(300.dp)
                            .align(Alignment.CenterHorizontally)

                        ,

                        shape = RoundedCornerShape(12),
                        colors = mainButtonColor,

                        onClick = {
                        viewModel.SignInUser()


                            toast.show()

                        onClick()
                    }
                    ) {
                        Text(text = "Sign In")
                    }




            }

        }



    }


}



