package screens

import Ability
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import components.Direccion
import components.PokemonHeader
import components.chip
import components.recibirPokemonSecundario
import dummies.getNextPokemon
import dummies.getPokemonByID
import dummies.getPreviousPokemon
import dummies.returnOnePokemon
import islas.abril.composepokedex_islasabril.Pokemon
import islas.abril.composepokedex_islasabril.R
import islas.abril.composepokedex_islasabril.ui.theme.ComposePokedex_IslasAbrilTheme
import islas.abril.composepokedex_islasabril.ui.theme.white
import pokemonEvolutions
import utilites.getColorsByType

@Preview(showBackground = true)
@Composable
fun PokemonPreview() {
    ComposePokedex_IslasAbrilTheme {
        val pokemon = getPokemonByID(133)
        Greeting(
            pokemon,
            getPreviousPokemon(pokemon.number),
            getNextPokemon(pokemon.number)
        )
    }
}

@Composable
fun Greeting(pokemon: Pokemon, previousPokemon: Pokemon,nextPokemon: Pokemon) {
    Column(
        Modifier.background(
            getColorsByType(pokemon).first
        )
    ) {
        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)
        PokemonCard(pokemon, previousPokemon, nextPokemon)

    }
}

@Composable
fun PokemonCard(pokemon: Pokemon, previousPokemon: Pokemon, nextPokemon: Pokemon) {
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

                    chip(
                        pokemon.type,
                        getColorsByType(pokemon).first,
                        Modifier.padding(top = 10.dp, bottom = 20.dp)
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
                    Row(modifier = Modifier.fillMaxWidth(.8f)
                        .align(CenterHorizontally)
                        .padding(top = 30.dp),
                        horizontalArrangement = Arrangement.Center) {
                        Column() {
                            Text("Evoluciones", Modifier,
                                fontWeight = FontWeight.Bold)
                            pokemonEvolutions(
                                pokemon.evolutions
                                )
                        }
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
                            nombre = previousPokemon.name,
                            direccion = Direccion.LEFT,
                            imagen = previousPokemon.imageRes,
                            numero = previousPokemon.number
                        )

                    }
                    Box(modifier = Modifier.weight(1f)) {
                        recibirPokemonSecundario(
                            nombre = nextPokemon.name,
                            direccion = Direccion.RIGHT,
                            imagen = nextPokemon.imageRes,
                            numero = nextPokemon.number
                        )
                    }
                }
            }
        }
    }
}
