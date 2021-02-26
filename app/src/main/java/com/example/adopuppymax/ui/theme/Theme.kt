package com.example.adopuppymax.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp

private val DarkColorPalette = darkColors(
    primary = max_color_main_light,
    primaryVariant = max_color_main_dark,
    secondary = Teal200,
    surface = PuppyDarkPrimary
)

private val LightColorPalette = lightColors(
    primary = max_color_main_mid,
    primaryVariant = max_color_main_dark,
    secondary = Teal200
)

private val LightElevation = Elevations()

private val DarkElevation = Elevations(card = 1.dp)

@Composable
fun PuppyMaxTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val elevation = if (darkTheme) DarkElevation else LightElevation
    CompositionLocalProvider(
        LocalElevations provides elevation
    ) {
        MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

object PuppyTheme {
    val elevations: Elevations
        @Composable
        get() = LocalElevations.current
}
