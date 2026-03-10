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
import islas.abril.composepokedex_islasabril.R

@Composable
fun PokemonHeader(name: String, number: Int, fav: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(35.dp,20.dp,20.dp,20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(text = name)
            Text(text = "#$number")
        }
        Image(
            painter = painterResource(
                if (fav) R.drawable.ic_smiley_filled
                else R.drawable.ic_smiley_outline
            ),
            contentDescription = if (fav) "Favorite" else "Not favorite",
            modifier = Modifier.size(24.dp)
        )
    }
}