package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun recibirPokemonSecundario(nombre: String, direccion: Direccion, imagen: Int, numero:Int ){


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement =
            if (direccion == Direccion.LEFT)
                Arrangement.Start
            else
                Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (direccion == Direccion.LEFT) {
            Image(
                painter = painterResource(
                    islas.abril.composepokedex_islasabril.R.drawable.ic_arrow_circle_left
                ),
                contentDescription = "Anterior",
                modifier = Modifier.size(32.dp)
            )
        }


        Column(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Image(
                painter = painterResource(id = imagen),
                contentDescription = nombre,
                modifier = Modifier.size(80.dp)
            )
            Row(
            ) {
                Text(text = nombre)
                Text(text = "#$numero")
            }
        }
        if (direccion == Direccion.RIGHT) {
            Image(
                painter = painterResource(
                    islas.abril.composepokedex_islasabril.R.drawable.ic_arrow_circle_right
                ),
                contentDescription = "Siguiente",
                modifier = Modifier.size(32.dp)
            )
        }
    }

}