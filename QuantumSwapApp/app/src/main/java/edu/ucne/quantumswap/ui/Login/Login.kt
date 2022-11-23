package edu.ucne.quantumswap.ui.login

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*


import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.text.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*


import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.quantumswap.R


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MyIcon(modifier: Modifier =Modifier.padding(bottom = 30.dp))
{
    Column(modifier = Modifier.padding(2.dp)) {
        Image(painterResource(R.drawable.logo), contentDescription = "")
    }
) {

}


@Composable
fun Login(
    onClick: () -> Unit,
    viewModel: Loginviewmodel = hiltViewModel()
) {

    val mainButtonColor = ButtonDefaults.buttonColors(
        containerColor = androidx.compose.ui.graphics.Color(25,118,210),
        contentColor = Color.White
    )
    val rippleColor = rememberRipple(color = Color(0xFF39C1D3))

    CompositionLocalProvider(
        LocalTextSelectionColors provides customTextSelectionColors,
        LocalIndication provides rippleColor
    ) {
        OutlinedTextField(
            value = inputValue.value,
            onValueChange = { inputValue.value = it },
            modifier = modifier
                .height(72.dp)
                .focusRequester(focusRequester)
                .onFocusChanged {
                    iconColor.value = if (it.isFocused) Color(0xFF1976D2)
                    else Color(0xFFC9C9C9)
                },
            label = {
                if (type == "uid")
                    Text(text = "Email Address*")
                else
                    Text(text = "Password*")
            },
            shape = RoundedCornerShape(25.dp),
            singleLine = true,
            colors = TextFieldDefaults
                .outlinedTextFieldColors(
                    unfocusedBorderColor = Color(0xFFC9C9C9),
                    focusedBorderColor = Color(0xFF1976D2),
                    leadingIconColor = iconColor.value,
                    trailingIconColor = iconColor.value,
                    cursorColor = Color(0xFF1976D2),
                    focusedLabelColor = Color(0xFF1976D2)
                ),

        )
    }
}

@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    gradient: Brush,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { onClick() },
        modifier = modifier.height(48.dp),
        shape = RoundedCornerShape(40.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 10.dp, pressedElevation = 5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(gradient)
                .padding(horizontal = 32.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = textColor
            )
        }
    }
}

@Composable
fun Login() {
    Surface(modifier = Modifier.fillMaxSize()) {
        val inputValueID = remember {
            mutableStateOf("")
        }
        val inputValuePass = remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(60.dp)
                .shadow(4.dp)
                .width(300.dp),
            onClick = {
                      viewModel.AuthUser()
                onClick()
            },
            shape = RoundedCornerShape(12), colors = mainButtonColor
        ){

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            bottomStart = 25.dp,
                            bottomEnd = 25.dp
                        )
                    )
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Color(0xFF1976D2),
                                Color(0xFF000000)
                            ),
                            radius = 415f
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(280.dp)
                        .offset(y = (-20.dp)),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Background Image"
                )
            }

            Card(
                modifier = Modifier
                    .offset(y = -20.dp)
                    .width(290.dp),
                shape = RoundedCornerShape(25.dp),
                elevation = 15.dp
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .padding(top = 30.dp, bottom = 50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "LOG IN", modifier = Modifier.padding(bottom = 16.dp))
                    CustomInputField(inputValue = inputValueID, type = "uid")
                    CustomInputField(inputValue = inputValuePass, type = "password")
                }
            }


            GradientButton(
                modifier = Modifier.offset(y = -50.dp),
                text = "Log in",
                textColor = Color.White,
                gradient = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF99B0C2),
                        Color(0xFF1976D2),
                        Color(0xFF1976D2)
                    )
                )
            ) {

            }

        }
    }
    
}


@Composable
fun PintaTextfiel(
    viewModel: Loginviewmodel = hiltViewModel()
)
{
    OutlinedTextField(
        modifier = Modifier
            .height(60.dp)
            .width(300.dp),
        value = viewModel.email,
        label = { Text(text = "Email Address*")},
        onValueChange = {viewModel.email = it},
        shape = CutCornerShape(5),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        )
    )
    Spacer(modifier = Modifier.padding(16.dp))
    OutlinedTextField(
        modifier = Modifier
            .height(60.dp)
            .width(300.dp),
        value = viewModel.password,
        label = { Text(text = "Password*")},
        onValueChange = {viewModel.password = it},
        shape = CutCornerShape(5),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )

    )
}


