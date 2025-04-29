package com.example.parcial2.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = AzulClaro,
    onPrimary = Blanco,
    background = GrisClaro,
    onBackground = Color.Black,
    surface = Blanco,
    onSurface = Color.Black,
)

@Composable
fun Parcial2Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}
