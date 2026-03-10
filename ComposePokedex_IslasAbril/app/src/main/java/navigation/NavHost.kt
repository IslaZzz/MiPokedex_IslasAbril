package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dummies.getNextPokemon
import dummies.getPokemonByID
import dummies.getPreviousPokemon
import dummies.showAllPokemons
import islas.abril.composepokedex_islasabril.Pokemon
import navigation.PokemonList
import screens.Greeting
import screens.PokedexMenuScreen

@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = PokemonList){
        composable<PokemonList>{
            PokedexMenuScreen(showAllPokemons(), onNavigationDetail = {id ->navController.navigate(route=PokemonDetail(id=id))})
        }
        composable<PokemonDetail> { backStackEntry ->
            val route: PokemonDetail = backStackEntry.toRoute()
            val pokemon = getPokemonByID(route.id)
            val previousPokemon = getPreviousPokemon(pokemon.number)
            val nextPokemon = getNextPokemon(pokemon.number)
            Greeting(pokemon, previousPokemon, nextPokemon)
        }
    }
}