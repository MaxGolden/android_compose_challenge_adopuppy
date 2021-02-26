package com.example.adopuppymax.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable

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

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

object PuppyTheme {
    val colors: Colors
        @Composable
        get() = MaterialTheme.colors

    val typography: Typography
        @Composable
        get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable
        get() = MaterialTheme.shapes

    val elevations: Elevations
        @Composable
        get() = LocalElevations.current
}
