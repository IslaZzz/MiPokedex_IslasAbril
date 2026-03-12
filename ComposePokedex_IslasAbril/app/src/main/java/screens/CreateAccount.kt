package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import islas.abril.composepokedex_islasabril.R
import islas.abril.composepokedex_islasabril.ui.theme.PurpleGrey40
import islas.abril.composepokedex_islasabril.ui.theme.beige
import islas.abril.composepokedex_islasabril.ui.theme.iceType
import islas.abril.composepokedex_islasabril.ui.theme.waterType

//@Preview(showBackground = true)
//@Composable
//fun PreviewCreateAccount(){
//    CreateAccount()
//}

@Composable
fun CreateAccount(
    onRegisterSuccess: () -> Unit
){

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(beige),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(
                    "My Pokedex",
                    color = PurpleGrey40,
                    fontWeight = FontWeight.Bold,
                    fontSize = 45.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "Provide your data",
                    color = PurpleGrey40,
                    fontSize = 17.sp
                )
                Image(
                    painter = painterResource(R.drawable.rotom),
                    contentDescription = "rotom logo",
                    Modifier.size(240.dp)
                        .align(Alignment.CenterHorizontally)

                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
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
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
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

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = {
                if(username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
                    onRegisterSuccess()
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = waterType,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(4.dp)
        ){
            Text("Create account",
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(message)
    }
}
