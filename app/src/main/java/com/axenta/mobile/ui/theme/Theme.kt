package com.axenta.mobile.ui.theme

import androidx.compose.foundation.isSystemInDarkMode
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryBlue,
    onPrimary = BackgroundDarker,
    primaryContainer = PrimaryBlueDark,
    onPrimaryContainer = PrimaryBlueLight,
    
    secondary = SecondaryPurple,
    onSecondary = BackgroundDarker,
    secondaryContainer = SecondaryPurpleDark,
    onSecondaryContainer = SecondaryPurpleLight,
    
    tertiary = TertiaryCyan,
    onTertiary = BackgroundDarker,
    tertiaryContainer = Color(0xFF00A8A8),
    onTertiaryContainer = Color(0xFF00FFEE),
    
    error = StatusError,
    onError = Color.White,
    errorContainer = Color(0xFFFF6666),
    onErrorContainer = Color.White,
    
    background = BackgroundDark,
    onBackground = TextPrimary,
    
    surface = SurfaceDark,
    onSurface = TextPrimary,
    surfaceVariant = SurfaceDarker,
    onSurfaceVariant = TextSecondary,
    
    outline = TextTertiary,
    outlineVariant = Color(0xFF666677)
)

@Composable
fun AXENTATheme(
    darkTheme: Boolean = isSystemInDarkMode(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = AXENTATypography,
        content = content
    )
}
