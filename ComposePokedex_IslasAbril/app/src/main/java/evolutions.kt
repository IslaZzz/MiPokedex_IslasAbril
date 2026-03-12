
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import components.pokemonGridItem
import dummies.returnOnePokemon
import islas.abril.composepokedex_islasabril.Pokemon

@Preview (showBackground = true)
@Composable
fun pokemonEvolutionsPreview() {
    val pokemon = returnOnePokemon()
    pokemonEvolutions(
        evolutions =  listOf(returnOnePokemon(), returnOnePokemon())

    )
}
@Composable
fun pokemonEvolutions(evolutions: List<Pokemon>) {
    LazyRow(
        contentPadding = PaddingValues(5.dp, 5.dp,5.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(evolutions) { pokemon ->

            pokemonGridItem(
                pokemon,
                onNavigationDetail = { number: Int -> }
            )
        }
    }
}