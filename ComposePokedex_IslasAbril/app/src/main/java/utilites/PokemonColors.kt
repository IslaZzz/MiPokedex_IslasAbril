package utilites

import androidx.compose.ui.graphics.Color
import islas.abril.composepokedex_islasabril.Pokemon
import islas.abril.composepokedex_islasabril.ui.theme.bugType
import islas.abril.composepokedex_islasabril.ui.theme.darkType
import islas.abril.composepokedex_islasabril.ui.theme.dragonType
import islas.abril.composepokedex_islasabril.ui.theme.elecYellow
import islas.abril.composepokedex_islasabril.ui.theme.fairyType
import islas.abril.composepokedex_islasabril.ui.theme.fightingType
import islas.abril.composepokedex_islasabril.ui.theme.fireType
import islas.abril.composepokedex_islasabril.ui.theme.flyingType
import islas.abril.composepokedex_islasabril.ui.theme.ghostType
import islas.abril.composepokedex_islasabril.ui.theme.grassType
import islas.abril.composepokedex_islasabril.ui.theme.groundType
import islas.abril.composepokedex_islasabril.ui.theme.iceType
import islas.abril.composepokedex_islasabril.ui.theme.normalType
import islas.abril.composepokedex_islasabril.ui.theme.poisonType
import islas.abril.composepokedex_islasabril.ui.theme.psychicType
import islas.abril.composepokedex_islasabril.ui.theme.rockType
import islas.abril.composepokedex_islasabril.ui.theme.steelType
import islas.abril.composepokedex_islasabril.ui.theme.waterType

fun getColorsByType(pokemon: Pokemon): Pair<Color,Boolean> {
    var color: Color
    var dark = false

    when {

        pokemon.type.lowercase().contains("eléctrico") -> {
            color = elecYellow
            dark = true
        }
        pokemon.type.lowercase().contains("agua") -> color = waterType
        pokemon.type.lowercase().contains("fuego") -> color = fireType
        pokemon.type.lowercase().contains("hierba") -> color = grassType
        pokemon.type.lowercase().contains("hielo") -> color = iceType
        pokemon.type.lowercase().contains("lucha") -> color = fightingType
        pokemon.type.lowercase().contains("veneno") -> color = poisonType
        pokemon.type.lowercase().contains("tierra") -> color = groundType
        pokemon.type.lowercase().contains("volador") -> color = flyingType
        pokemon.type.lowercase().contains("psiquico") -> color = psychicType
        pokemon.type.lowercase().contains("bicho") -> color = bugType
        pokemon.type.lowercase().contains("roca") -> color = rockType
        pokemon.type.lowercase().contains("fantasma") -> color = ghostType
        pokemon.type.lowercase().contains("dragon") -> color = dragonType
        pokemon.type.lowercase().contains("acero") -> color = steelType
        pokemon.type.lowercase().contains("siniestro") -> color = darkType
        pokemon.type.lowercase().contains("hada") -> color = fairyType

        else -> {
            color = normalType
            dark = true
        }
    }
    return Pair(color, dark)
}