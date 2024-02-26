package nz.ac.uclive.dsi61.morsecompose.ui.theme

//import androidx.compose.material3.Typography
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 64.sp,
        fontFeatureSettings = "c2sc, smcp"
    ),
)