package com.typez.keyboard.app.uix.settings.pages

import androidx.compose.ui.res.stringResource
import com.typez.keyboard.app.R
import com.typez.keyboard.app.uix.SettingsExporter
import com.typez.keyboard.app.uix.settings.NavigationItemStyle
import com.typez.keyboard.app.uix.settings.ScreenTitle
import com.typez.keyboard.app.uix.settings.Tip
import com.typez.keyboard.app.uix.settings.UserSettingsMenu
import com.typez.keyboard.app.uix.settings.userSettingDecorationOnly
import com.typez.keyboard.app.uix.settings.userSettingNavigationItem

val MiscMenu = UserSettingsMenu(
    title = R.string.misc_settings_title,
    navPath = "misc", registerNavPath = true,
    settings = listOf(
        userSettingDecorationOnly {
            ScreenTitle(stringResource(R.string.settings_export_configuration_title))
        },

        userSettingNavigationItem(
            title = (R.string.settings_export_configuration),
            subtitle = (R.string.settings_export_configuration_subtitle),
            style = NavigationItemStyle.Misc,
            navigateTo = "exportingcfg"
        ).copy(searchTags = R.string.settings_import_export_tags),
        userSettingNavigationItem(
            title = (R.string.settings_import_configuration),
            subtitle = (R.string.settings_import_configuration_subtitle),
            style = NavigationItemStyle.Misc,
            navigate = { nav ->
                SettingsExporter.triggerImportSettings(nav.context)
            }
        ).copy(searchTags = R.string.settings_import_export_tags),
    )
)
