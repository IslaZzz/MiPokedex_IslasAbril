package islas.abril.composepokedex_islasabril

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import islas.abril.composepokedex_islasabril.ui.theme.ComposePokedex_IslasAbrilTheme
import navigation.MyApp
data class Pokemon(
    val name: String,
    val number: Int,
    val type : String,
    val fav: Boolean,
    val weight: Double,
    val height: Double,
    val description: String,
    val ability: String,
    val imageRes: Int,
    var evolutions: List<Pokemon>
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedex_IslasAbrilTheme {
                MyApp()
                }
            }
        }
    }
