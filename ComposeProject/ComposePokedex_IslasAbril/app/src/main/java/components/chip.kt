package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import islas.abril.composepokedex_islasabril.ui.theme.elecYellow


@Composable
fun chip(text:String, color: Color, modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .background(color, RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp, vertical = 5.dp)
    )
    {
        Text(text)
    }

}
@Preview(showBackground = true)

@Composable
fun chipPreview(){
    chip("Eléctrico", elecYellow)
}

