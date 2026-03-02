package islas.abril.composepokedex_islasabril

import Ability
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import components.Direccion
import components.chip
import components.recibirPokemonSecundario
import islas.abril.composepokedex_islasabril.ui.theme.ComposePokedex_IslasAbrilTheme
import islas.abril.composepokedex_islasabril.ui.theme.elecYellow
import islas.abril.composepokedex_islasabril.ui.theme.white

data class Pokemon(
    val name: String,
    val number: Int,
    val type : String,
    val fav: Boolean,
    val weight: Double,
    val height: Double,
    val description: String,
    val ability: String,
    val imageRes: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedex_IslasAbrilTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val pikachu = Pokemon(
                        name = "Pikachu",
                        number = 25,
                        fav = true,
                        type = "electrico",
                        weight = 6.0,
                        height = 0.4,
                        description = "Electric type Pokémon",
                        ability = "Static",
                        imageRes = R.drawable.pikachu
                    )

                    Greeting(
                        pokemon = pikachu,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
//recibir color eventualmente
fun Greeting(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Column(
        Modifier.background(elecYellow)
    ) {
        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)
        PokemonCard(pokemon)

    }
}

@Composable
fun PokemonHeader(name: String, number: Int, fav: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(20.dp),
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

@Composable
fun PokemonCard(pokemon: Pokemon) {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier.fillMaxSize()
    ) {
            Image(
                painter = painterResource(R.drawable.pokeball),
                contentDescription = "Pokeball fondo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(250.dp)
                    .offset(x = 70.dp, y = (-70).dp)
            )

        Image(
            painterResource(pokemon.imageRes), contentDescription = pokemon.name,
            modifier = Modifier.offset(0.dp, -45.dp)
                .zIndex(2f)
                .size(200.dp),
            contentScale = ContentScale.Fit
        )

        Card(
            Modifier.fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 120.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
            colors = CardDefaults.cardColors(white),
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {

                Column(
                    Modifier.fillMaxWidth()
                        .padding(top = 35.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    //dependiendo del tipo cambiar el color
                    chip(
                        pokemon.type, elecYellow, Modifier.padding(top = 10.dp, bottom = 20.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(.8f)
                            .align(Alignment.CenterHorizontally),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column {
                            Ability("row", "Altura  ", "${pokemon.height} m")
                            Ability("row", "Peso    ", "${pokemon.weight} kg")

                        }
                        Ability("column", "Habilidad", value = pokemon.ability)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(.8f)
                            .align(CenterHorizontally)
                            .padding(top = 50.dp),
                            horizontalArrangement = Arrangement.Center
                    ) {
                        Text(pokemon.description, Modifier)
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(16.dp)
                ) {

                    Box(modifier = Modifier.weight(1f)) {
                        recibirPokemonSecundario(
                            nombre = "Riolu",
                            direccion = Direccion.LEFT,
                            imagen = R.drawable.riolu,
                            numero = 447
                        )

                    }
                    Box(modifier = Modifier.weight(1f)) {
                        recibirPokemonSecundario(
                            nombre = "Tepig",
                            direccion = Direccion.RIGHT,
                            imagen = R.drawable.tepig,
                            numero = 498
                        )
                    }
                }
            }
        }
    }
}

//composable para el resto de elementos (pokemones secundarios)
// y dinamico con el left or right
//nueva branch
@Preview(showBackground = true)
@Composable
fun PokemonPreview() {
    ComposePokedex_IslasAbrilTheme {
        val previewPokemon = Pokemon(
            name = "Pikachu",
            number = 25,
            fav = true,
            type = "Eléctrico",
            weight = 6.0,
            height = 0.4,
            description = "Pequeño Pokémon eléctrico valiente, rápido y adorable compañero leal icónico.",
            ability = "estática",
            imageRes = R.drawable.pikachu
        )
        Greeting(previewPokemon)
    }
}
