package com.typez.keyboard.app.engine

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
// import com.typez.keyboard.app.engine.general.JapaneseIMESettings  // Temporarily disabled
import com.typez.keyboard.app.R
import com.typez.keyboard.app.Subtypes
import com.typez.keyboard.app.SubtypesSetting
import com.typez.keyboard.app.uix.settings.NavigationItemStyle
import com.typez.keyboard.app.uix.settings.UserSettingsMenu
import com.typez.keyboard.app.uix.settings.useDataStoreValue
import com.typez.keyboard.app.uix.settings.userSettingNavigationItem

@Composable
private fun isVisible(language: String): Boolean {
    val subtypeSet = useDataStoreValue(SubtypesSetting)
    return remember(subtypeSet) {
        subtypeSet.any {
            Subtypes.getLocale(Subtypes.convertToSubtype(it).locale).language == language
        }
    }
}

val SettingsByLanguage: Map<String, Any> = mapOf(
    // "ja" to JapaneseIMESettings.menu.copy(visibilityCheck = { isVisible("ja") })  // Temporarily disabled
)

@Composable
private fun anyVisible(): Boolean {
    val subtypeSet = useDataStoreValue(SubtypesSetting)
    return remember(subtypeSet) {
        subtypeSet.any {
            SettingsByLanguage.containsKey(Subtypes.getLocale(Subtypes.convertToSubtype(it).locale).language)
        }
    }
}

private val IMESettings = emptyList<org.futo.inputmethod.latin.uix.settings.UserSetting>()
// buildList<Any> {
//     // Temporarily disabled since SettingsByLanguage is empty
//     // SettingsByLanguage.forEach {
//     //     add(
//     //         userSettingNavigationItem(
//     //             title = it.value.title,
//     //             style = NavigationItemStyle.HomePrimary,
//     //             icon = R.drawable.globe,
//     //             navigateTo = it.value.navPath,
//     //         ).copy(
//     //             visibilityCheck = it.value.visibilityCheck,
//     //             appearInSearchIfVisibilityCheckFailed = false
//     //         )
//     //     )
//     // }
// }

val IMESettingsMenu = UserSettingsMenu(
    title = R.string.language_specific_settings_title,
    navPath = "ime", registerNavPath = true,
    settings = IMESettings, visibilityCheck = { anyVisible() }
)
