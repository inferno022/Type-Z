package com.typez.keyboard.app.uix.theme

import android.content.Context
import androidx.annotation.StringRes
import com.typez.keyboard.app.R
import com.typez.keyboard.app.uix.KeyboardColorScheme
import com.typez.keyboard.app.uix.actions.BugInfo
import com.typez.keyboard.app.uix.actions.BugViewerState
import com.typez.keyboard.app.uix.theme.presets.AMOLEDDarkPurple
import com.typez.keyboard.app.uix.theme.presets.CatppuccinMocha
import com.typez.keyboard.app.uix.theme.presets.ClassicMaterialDark
import com.typez.keyboard.app.uix.theme.presets.ClassicMaterialLight
import com.typez.keyboard.app.uix.theme.presets.CottonCandy
import com.typez.keyboard.app.uix.theme.presets.DeepSeaDark
import com.typez.keyboard.app.uix.theme.presets.DeepSeaLight
import com.typez.keyboard.app.uix.theme.presets.DefaultDarkScheme
import com.typez.keyboard.app.uix.theme.presets.DefaultLightScheme
import com.typez.keyboard.app.uix.theme.presets.DynamicDarkTheme
import com.typez.keyboard.app.uix.theme.presets.DynamicLightTheme
import com.typez.keyboard.app.uix.theme.presets.DynamicSystemTheme
import com.typez.keyboard.app.uix.theme.presets.Emerald
import com.typez.keyboard.app.uix.theme.presets.Gradient1
import com.typez.keyboard.app.uix.theme.presets.Gradient2
import com.typez.keyboard.app.uix.theme.presets.Gradient3
import com.typez.keyboard.app.uix.theme.presets.Gradient4
import com.typez.keyboard.app.uix.theme.presets.Gradient5
import com.typez.keyboard.app.uix.theme.presets.Gradient6
import com.typez.keyboard.app.uix.theme.presets.HotDog
import com.typez.keyboard.app.uix.theme.presets.Snowfall
import com.typez.keyboard.app.uix.theme.presets.SteelGray
import com.typez.keyboard.app.uix.theme.presets.Sunflower
import com.typez.keyboard.app.uix.theme.presets.VoiceInputTheme
import com.typez.keyboard.app.uix.theme.presets.DevTheme
import com.typez.keyboard.app.uix.theme.presets.HighContrastYellow

data class ThemeOption(
    val dynamic: Boolean,
    val key: String,
    @StringRes val name: Int,
    val available: (Context) -> Boolean,
    val obtainColors: (Context) -> KeyboardColorScheme,
)

val ThemeOptions = mapOf(
    DefaultDarkScheme.key to DefaultDarkScheme,
    DefaultLightScheme.key to DefaultLightScheme,

    DynamicSystemTheme.key to DynamicSystemTheme,
    DynamicDarkTheme.key to DynamicDarkTheme,
    DynamicLightTheme.key to DynamicLightTheme,

    ClassicMaterialDark.key to ClassicMaterialDark,
    ClassicMaterialLight.key to ClassicMaterialLight,
    AMOLEDDarkPurple.key to AMOLEDDarkPurple,

    Sunflower.key to Sunflower,
    Snowfall.key to Snowfall,
    SteelGray.key to SteelGray,
    Emerald.key to Emerald,
    CottonCandy.key to CottonCandy,

    DeepSeaLight.key to DeepSeaLight,
    DeepSeaDark.key to DeepSeaDark,

    Gradient1.key to Gradient1,
    Gradient2.key to Gradient2,
    Gradient3.key to Gradient3,
    Gradient4.key to Gradient4,
    Gradient5.key to Gradient5,
    Gradient6.key to Gradient6,
    VoiceInputTheme.key to VoiceInputTheme,
    HotDog.key to HotDog,
    DevTheme.key to DevTheme,
    HighContrastYellow.key to HighContrastYellow,
    CatppuccinMocha.key to CatppuccinMocha,
)

val ThemeOptionKeys = ThemeOptions.keys

fun defaultThemeOption(context: Context): ThemeOption =
    if(context.resources.getBoolean(R.bool.use_dev_styling)) {
        DevTheme
    } else {
        if(DynamicSystemTheme.available(context)) {
            DynamicSystemTheme
        } else {
            DefaultDarkScheme
        }
    }

fun getThemeOption(context: Context, key: String): ThemeOption? {
    return ThemeOptions[key] ?: run {
        return ZipThemes.ThemeFileName.fromSetting(key)?.let { name ->
            ThemeOption(
                dynamic = false,
                key = key,
                name = 0,
                available = { true },
                obtainColors = {
                    try {
                        ZipThemes.loadScheme(context, name)
                    } catch(e: Exception) {
                        BugViewerState.pushBug(BugInfo(
                            name = "Theme $name",
                            details = e.toString(),
                        ))
                        defaultThemeOption(context).obtainColors(it)
                    }
                }
            )
        }
    }
}

fun ThemeOption?.orDefault(context: Context): ThemeOption {
    val themeOptionFromSettings = this
    val themeOption = when {
        themeOptionFromSettings == null -> defaultThemeOption(context)
        !themeOptionFromSettings.available(context) -> defaultThemeOption(context)
        else -> themeOptionFromSettings
    }

    return themeOption
}
