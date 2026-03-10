import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
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
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(5.dp, 5.dp,5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
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