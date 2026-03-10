package components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dummies.returnOnePokemon
import islas.abril.composepokedex_islasabril.Pokemon
import islas.abril.composepokedex_islasabril.ui.theme.white
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import islas.abril.composepokedex_islasabril.ui.theme.black
import utilites.getColorsByType

@Composable
fun pokemonGridItem(pokemon: Pokemon, onNavigationDetail:(id:Int) -> Unit){

    val colors = getColorsByType(pokemon)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {
            onNavigationDetail(pokemon.number)
        }
    ) {

        Box {
            Image(
                painterResource(pokemon.imageRes),
                contentDescription = pokemon.name,
                modifier = Modifier.size(150.dp),
                contentScale = androidx.compose.ui.layout.ContentScale.Fit
            )

            Row(
                Modifier.size(35.dp)
                    .background(colors.first, shape = RoundedCornerShape(40.dp))
                    .align(Alignment.TopEnd),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    "${pokemon.number}",
                    color = if(colors.second) black else white,
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Text(
            pokemon.name,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = colors.first
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonGridItemPreview(){
    pokemonGridItem(returnOnePokemon(), onNavigationDetail = {number:Int->{}})
}