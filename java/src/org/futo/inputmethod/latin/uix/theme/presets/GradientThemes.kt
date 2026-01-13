package org.futo.inputmethod.latin.uix.theme.presets

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.extendedDarkColorScheme
import org.futo.inputmethod.latin.uix.theme.ThemeOption

private val gradientScheme1 = extendedDarkColorScheme(
    primary=Color(0xFFF786F1),
    onPrimary=Color(0xFF520B4E),
    primaryContainer=Color(0xFF102347),
    onPrimaryContainer=Color(0xFFE5EEFF),
    secondary= Color(0xFFF7D0F5),
    onSecondary=Color(0xFF80457C),
    secondaryContainer=Color(0xFF162033),
    onSecondaryContainer=Color(0xFFABBAD9),
    tertiary=Color(0xFF7FEB86),
    onTertiary=Color(0xFF145218),
    tertiaryContainer=Color(0xFF246B29),
    onTertiaryContainer=Color(0xFFD6FFD9),
    error=Color(0xFFFF8C80),
    onError=Color(0xFF4D2B2B),
    errorContainer=Color(0xFF803B3B),
    onErrorContainer=Color(0xFFFFDFDB),
    outline=Color(0xFFB1A9CC),
    outlineVariant=Color(0xFF363340),
    surface=Color(0xFF0E0E1A),
    onSurface=Color(0xFFE1E9FA),
    onSurfaceVariant=Color(0xFFC8C9CC),
    surfaceContainerHighest=Color(0xFF2E384D),
    shadow=Color(0xFF000000).copy(alpha = 0.7f),
    keyboardSurface=Color(0xFF0F2F6E),
    keyboardContainer=Color(0xFFFFFFFF).copy(alpha = 0.17f),
    keyboardContainerVariant=Color(0xFFFFFFFF).copy(alpha = 0.08f),
    onKeyboardContainer=Color(0xFFFFFFFF),
    keyboardPress=Color(0xFF7D56BF),
    keyboardFade0=Color(0xFF0F2F6E),
    keyboardFade1=Color(0xFF0F2F6E),
    primaryTransparent=Color(0xFFEB7FE4).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFE1E9FA).copy(alpha = 0.1f),

    keyboardBackgroundGradient = Brush.verticalGradient(
        0.0f to Color(0xFF123A87),
        1.0f to Color(0xFF852D80)
    ),
    navigationBarColor = Color(0xFF852D80),
    navigationBarColorForTransparency = Color(0xFF000000),
)

// New themes based on provided color schemes

// Purple/Blue gradient theme
private val gradientScheme2 = extendedDarkColorScheme(
    primary=Color(0xFF7C3AED), // Purple accent
    onPrimary=Color(0xFFFFFFFF),
    primaryContainer=Color(0xFF1E1B4B),
    onPrimaryContainer=Color(0xFFE9D5FF),
    secondary= Color(0xFF8B5CF6), // Light purple
    onSecondary=Color(0xFFFFFFFF),
    secondaryContainer=Color(0xFF2D1B69),
    onSecondaryContainer=Color(0xFFDDD6FE),
    tertiary=Color(0xFF60A5FA), // Blue accent
    onTertiary=Color(0xFFFFFFFF),
    tertiaryContainer=Color(0xFF1E3A8A),
    onTertiaryContainer=Color(0xFFDCE7FE),
    error=Color(0xFFF87171),
    onError=Color(0xFFFFFFFF),
    errorContainer=Color(0xFF7F1D1D),
    onErrorContainer=Color(0xFFFECACA),
    outline=Color(0xFFA78BFA),
    outlineVariant=Color(0xFF4C1D95),
    surface=Color(0xFF0F172A),
    onSurface=Color(0xFFF1F5F9),
    onSurfaceVariant=Color(0xFFCBD5E1),
    surfaceContainerHighest=Color(0xFF1E293B),
    shadow=Color(0xFF000000).copy(alpha = 0.8f),
    keyboardSurface=Color(0xFF1E1B4B),
    keyboardContainer=Color(0xFFFFFFFF).copy(alpha = 0.15f),
    keyboardContainerVariant=Color(0xFFFFFFFF).copy(alpha = 0.08f),
    onKeyboardContainer=Color(0xFFFFFFFF),
    keyboardPress=Color(0xFF7C3AED), // Purple accent as keyboard press
    keyboardFade0=Color(0xFF1E1B4B),
    keyboardFade1=Color(0xFF2D1B69),
    primaryTransparent=Color(0xFF7C3AED).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFF1F5F9).copy(alpha = 0.1f),

    keyboardBackgroundGradient = Brush.verticalGradient(
        0.0f to Color(0xFF1E1B4B),
        0.5f to Color(0xFF312E81),
        1.0f to Color(0xFF1E40AF)
    ),
    navigationBarColor = Color(0xFF1E1B4B),
    navigationBarColorForTransparency = Color(0xFF000000),
)

// Green/Teal gradient theme
private val gradientScheme3 = extendedDarkColorScheme(
    primary=Color(0xFF10B981), // Green accent
    onPrimary=Color(0xFFFFFFFF),
    primaryContainer=Color(0xFF064E3B),
    onPrimaryContainer=Color(0xFFA7F3D0),
    secondary= Color(0xFF14B8A6), // Teal
    onSecondary=Color(0xFFFFFFFF),
    secondaryContainer=Color(0xFF134E4A),
    onSecondaryContainer=Color(0xFFCCFBF1),
    tertiary=Color(0xFF84CC16), // Lime green
    onTertiary=Color(0xFFFFFFFF),
    tertiaryContainer=Color(0xFF365314),
    onTertiaryContainer=Color(0xFFECFCCB),
    error=Color(0xFFF87171),
    onError=Color(0xFFFFFFFF),
    errorContainer=Color(0xFF7F1D1D),
    onErrorContainer=Color(0xFFFECACA),
    outline=Color(0xFF6EE7B7),
    outlineVariant=Color(0xFF065F46),
    surface=Color(0xFF0F172A),
    onSurface=Color(0xFFF1F5F9),
    onSurfaceVariant=Color(0xFFCBD5E1),
    surfaceContainerHighest=Color(0xFF1E293B),
    shadow=Color(0xFF000000).copy(alpha = 0.8f),
    keyboardSurface=Color(0xFF064E3B),
    keyboardContainer=Color(0xFFFFFFFF).copy(alpha = 0.15f),
    keyboardContainerVariant=Color(0xFFFFFFFF).copy(alpha = 0.08f),
    onKeyboardContainer=Color(0xFFFFFFFF),
    keyboardPress=Color(0xFF10B981), // Green accent as keyboard press
    keyboardFade0=Color(0xFF064E3B),
    keyboardFade1=Color(0xFF134E4A),
    primaryTransparent=Color(0xFF10B981).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFF1F5F9).copy(alpha = 0.1f),

    keyboardBackgroundGradient = Brush.verticalGradient(
        0.0f to Color(0xFF064E3B),
        0.5f to Color(0xFF047857),
        1.0f to Color(0xFF065F46)
    ),
    navigationBarColor = Color(0xFF064E3B),
    navigationBarColorForTransparency = Color(0xFF000000),
)

// Orange/Red gradient theme
private val gradientScheme4 = extendedDarkColorScheme(
    primary=Color(0xFFF97316), // Orange accent
    onPrimary=Color(0xFFFFFFFF),
    primaryContainer=Color(0xFF7C2D12),
    onPrimaryContainer=Color(0xFFFED7AA),
    secondary= Color(0xFFEF4444), // Red
    onSecondary=Color(0xFFFFFFFF),
    secondaryContainer=Color(0xFF7F1D1D),
    onSecondaryContainer=Color(0xFFFECACA),
    tertiary=Color(0xFFFCD34D), // Yellow
    onTertiary=Color(0xFF78350F),
    tertiaryContainer=Color(0xFF451A03),
    onTertiaryContainer=Color(0xFFFEF3C7),
    error=Color(0xFFF87171),
    onError=Color(0xFFFFFFFF),
    errorContainer=Color(0xFF7F1D1D),
    onErrorContainer=Color(0xFFFECACA),
    outline=Color(0xFFFDBA74),
    outlineVariant=Color(0xFF7C2D12),
    surface=Color(0xFF0F172A),
    onSurface=Color(0xFFF1F5F9),
    onSurfaceVariant=Color(0xFFCBD5E1),
    surfaceContainerHighest=Color(0xFF1E293B),
    shadow=Color(0xFF000000).copy(alpha = 0.8f),
    keyboardSurface=Color(0xFF7C2D12),
    keyboardContainer=Color(0xFFFFFFFF).copy(alpha = 0.15f),
    keyboardContainerVariant=Color(0xFFFFFFFF).copy(alpha = 0.08f),
    onKeyboardContainer=Color(0xFFFFFFFF),
    keyboardPress=Color(0xFFF97316), // Orange accent as keyboard press
    keyboardFade0=Color(0xFF7C2D12),
    keyboardFade1=Color(0xFF7F1D1D),
    primaryTransparent=Color(0xFFF97316).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFF1F5F9).copy(alpha = 0.1f),

    keyboardBackgroundGradient = Brush.verticalGradient(
        0.0f to Color(0xFF7C2D12),
        0.5f to Color(0xFF991B1B),
        1.0f to Color(0xFFB91C1C)
    ),
    navigationBarColor = Color(0xFF7C2D12),
    navigationBarColorForTransparency = Color(0xFF000000),
)

// Pink/Purple gradient theme
private val gradientScheme5 = extendedDarkColorScheme(
    primary=Color(0xFFEC4899), // Pink accent
    onPrimary=Color(0xFFFFFFFF),
    primaryContainer=Color(0xFF831843),
    onPrimaryContainer=Color(0xFFFFD6E4),
    secondary= Color(0xFFA855F7), // Purple
    onSecondary=Color(0xFFFFFFFF),
    secondaryContainer=Color(0xFF581C87),
    onSecondaryContainer=Color(0xFFE9D5FF),
    tertiary=Color(0xFFF472B6), // Light pink
    onTertiary=Color(0xFFFFFFFF),
    tertiaryContainer=Color(0xFF9F1239),
    onTertiaryContainer=Color(0xFFFFD6E4),
    error=Color(0xFFF87171),
    onError=Color(0xFFFFFFFF),
    errorContainer=Color(0xFF7F1D1D),
    onErrorContainer=Color(0xFFFECACA),
    outline=Color(0xFFF9A8D4),
    outlineVariant=Color(0xFF831843),
    surface=Color(0xFF0F172A),
    onSurface=Color(0xFFF1F5F9),
    onSurfaceVariant=Color(0xFFCBD5E1),
    surfaceContainerHighest=Color(0xFF1E293B),
    shadow=Color(0xFF000000).copy(alpha = 0.8f),
    keyboardSurface=Color(0xFF831843),
    keyboardContainer=Color(0xFFFFFFFF).copy(alpha = 0.15f),
    keyboardContainerVariant=Color(0xFFFFFFFF).copy(alpha = 0.08f),
    onKeyboardContainer=Color(0xFFFFFFFF),
    keyboardPress=Color(0xFFEC4899), // Pink accent as keyboard press
    keyboardFade0=Color(0xFF831843),
    keyboardFade1=Color(0xFF581C87),
    primaryTransparent=Color(0xFFEC4899).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFF1F5F9).copy(alpha = 0.1f),

    keyboardBackgroundGradient = Brush.verticalGradient(
        0.0f to Color(0xFF831843),
        0.5f to Color(0xFFA855F7),
        1.0f to Color(0xFFC026D3)
    ),
    navigationBarColor = Color(0xFF831843),
    navigationBarColorForTransparency = Color(0xFF000000),
)

// Dark Blue/Light Blue gradient theme
private val gradientScheme6 = extendedDarkColorScheme(
    primary=Color(0xFF3B82F6), // Blue accent
    onPrimary=Color(0xFFFFFFFF),
    primaryContainer=Color(0xFF1E3A8A),
    onPrimaryContainer=Color(0xFFDCE7FE),
    secondary= Color(0xFF64748B), // Slate blue
    onSecondary=Color(0xFFFFFFFF),
    secondaryContainer=Color(0xFF334155),
    onSecondaryContainer=Color(0xFFE2E8F0),
    tertiary=Color(0xFF06B6D4), // Cyan
    onTertiary=Color(0xFFFFFFFF),
    tertiaryContainer=Color(0xFF164E63),
    onTertiaryContainer=Color(0xFFCFFAFE),
    error=Color(0xFFF87171),
    onError=Color(0xFFFFFFFF),
    errorContainer=Color(0xFF7F1D1D),
    onErrorContainer=Color(0xFFFECACA),
    outline=Color(0xFF93C5FD),
    outlineVariant=Color(0xFF1E3A8A),
    surface=Color(0xFF0F172A),
    onSurface=Color(0xFFF1F5F9),
    onSurfaceVariant=Color(0xFFCBD5E1),
    surfaceContainerHighest=Color(0xFF1E293B),
    shadow=Color(0xFF000000).copy(alpha = 0.8f),
    keyboardSurface=Color(0xFF1E3A8A),
    keyboardContainer=Color(0xFFFFFFFF).copy(alpha = 0.15f),
    keyboardContainerVariant=Color(0xFFFFFFFF).copy(alpha = 0.08f),
    onKeyboardContainer=Color(0xFFFFFFFF),
    keyboardPress=Color(0xFF3B82F6), // Blue accent as keyboard press
    keyboardFade0=Color(0xFF1E3A8A),
    keyboardFade1=Color(0xFF334155),
    primaryTransparent=Color(0xFF3B82F6).copy(alpha = 0.3f),
    onSurfaceTransparent=Color(0xFFF1F5F9).copy(alpha = 0.1f),

    keyboardBackgroundGradient = Brush.verticalGradient(
        0.0f to Color(0xFF1E3A8A),
        0.5f to Color(0xFF1E40AF),
        1.0f to Color(0xFF0891B2)
    ),
    navigationBarColor = Color(0xFF1E3A8A),
    navigationBarColorForTransparency = Color(0xFF000000),
)


val Gradient1 = ThemeOption(
    dynamic = false,
    key = "Gradient1",
    name = R.string.theme_gradient1,
    available = { true }
) {
    gradientScheme1
}

val Gradient2 = ThemeOption(
    dynamic = false,
    key = "Gradient2",
    name = R.string.theme_gradient2,
    available = { true }
) {
    gradientScheme2
}

val Gradient3 = ThemeOption(
    dynamic = false,
    key = "Gradient3",
    name = R.string.theme_gradient3,
    available = { true }
) {
    gradientScheme3
}

val Gradient4 = ThemeOption(
    dynamic = false,
    key = "Gradient4",
    name = R.string.theme_gradient4,
    available = { true }
) {
    gradientScheme4
}

val Gradient5 = ThemeOption(
    dynamic = false,
    key = "Gradient5",
    name = R.string.theme_gradient5,
    available = { true }
) {
    gradientScheme5
}

val Gradient6 = ThemeOption(
    dynamic = false,
    key = "Gradient6",
    name = R.string.theme_gradient6,
    available = { true }
) {
    gradientScheme6
}