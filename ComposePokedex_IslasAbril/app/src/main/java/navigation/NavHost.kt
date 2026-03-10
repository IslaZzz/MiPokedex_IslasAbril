package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dummies.getNextPokemon
import dummies.getPokemonByID
import dummies.getPreviousPokemon
import dummies.initializePokemonEvolutions
import dummies.showAllPokemons
import screens.CreateAccount
import screens.Greeting
import screens.PokedexMenuScreen
import screens.loginAccount

@Composable
fun MyApp(){

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = Login
    ){
        composable<PokemonList>{
            PokedexMenuScreen(showAllPokemons(), onNavigationDetail = {id ->navController.navigate(route=PokemonDetail(id=id))})
        }

        composable<Login>{
            loginAccount(
                onLoginSuccess = {
                    navController.navigate(PokemonList)
                },
                onRegisterClick = {
                    navController.navigate(Register)
                }
            )
        }

        composable<Register>{
            CreateAccount(
                onRegisterSuccess = {
                    navController.navigate(Login)
                }
            )
        }

        composable<PokemonDetail> { backStackEntry ->

            initializePokemonEvolutions()
            val route: PokemonDetail = backStackEntry.toRoute()
            val pokemon = getPokemonByID(route.id)
            val previousPokemon = getPreviousPokemon(pokemon.number)
            val nextPokemon = getNextPokemon(pokemon.number)
            Greeting(pokemon, previousPokemon, nextPokemon)
        }
    }
}