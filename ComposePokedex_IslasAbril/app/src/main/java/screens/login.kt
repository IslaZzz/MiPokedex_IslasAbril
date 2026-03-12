package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import islas.abril.composepokedex_islasabril.R
import islas.abril.composepokedex_islasabril.ui.theme.PurpleGrey40
import islas.abril.composepokedex_islasabril.ui.theme.beige
import islas.abril.composepokedex_islasabril.ui.theme.fightingType
import islas.abril.composepokedex_islasabril.ui.theme.fireType
import islas.abril.composepokedex_islasabril.ui.theme.iceType
import islas.abril.composepokedex_islasabril.ui.theme.reddy
import islas.abril.composepokedex_islasabril.ui.theme.waterType

@Preview (showBackground = true)
@Composable
fun previewLoginAccount(){
   loginAccount({}, {})
}

@Composable
    fun loginAccount(
        onLoginSuccess: () -> Unit,
        onRegisterClick: () -> Unit
    ){

        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(beige),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(modifier = Modifier.align(Alignment.CenterHorizontally)){
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
                )
            {
                Text("My Pokedex",
                    color = PurpleGrey40,
                    fontWeight = FontWeight.Bold,
                    fontSize = 45.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text("Insert your credentials",
                    color = PurpleGrey40,
                    fontSize = 17.sp
                )
                
                Spacer(Modifier.height(20.dp))

                Image(
                    painter = painterResource(R.drawable.rotom),
                    contentDescription = "rotom logo",
                    Modifier.size(240.dp)
                        .align(Alignment.CenterHorizontally)

                )
            }
        }

        TextField(
            modifier = Modifier.padding(10.dp)
                .background(Color.White),
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = iceType
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = iceType
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.padding(20.dp,30.dp,20.dp,10.dp)
        ) {
            Button(
                onClick = {
                    onLoginSuccess()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = waterType,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 20.sp
                )
            }

            Button(modifier = Modifier.padding(15.dp,0.dp,0.dp,0.dp),
                onClick = {
                    onRegisterClick()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = waterType,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(4.dp)
            ){
                Text("Sign Up",
                    fontSize = 20.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Text(message)
    }


    }