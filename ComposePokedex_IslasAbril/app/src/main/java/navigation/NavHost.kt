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
import screens.CreateAccount
import screens.Greeting
import screens.loginAccount

@Composable
fun MyApp(){

    val navController = rememberNavController()

    initializePokemonEvolutions()

    NavHost(
        navController = navController,
        startDestination = Login
    ){

        composable<Login>{
            loginAccount(
                onLoginSuccess = {
                    navController.navigate(PokemonDetail)
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

            val route: PokemonDetail = backStackEntry.toRoute()

            val pokemon = getPokemonByID(route.id)
            val previousPokemon = getPreviousPokemon(pokemon.number)
            val nextPokemon = getNextPokemon(pokemon.number)

            Greeting(pokemon, previousPokemon, nextPokemon)
        }
    }
}