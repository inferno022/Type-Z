package com.typez.keyboard.app.uix.settings

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.typez.keyboard.app.engine.IMESettingsMenu
import com.typez.keyboard.app.engine.SettingsByLanguage
import com.typez.keyboard.app.R
import com.typez.keyboard.app.uix.ErrorDialog
import com.typez.keyboard.app.uix.InfoDialog
import com.typez.keyboard.app.uix.LocalNavController
import com.typez.keyboard.app.uix.SettingsExporter.ExportingMenu
import com.typez.keyboard.app.uix.actions.AllActions
import com.typez.keyboard.app.uix.settings.pages.ActionEditorScreen
import com.typez.keyboard.app.uix.settings.pages.ActionsScreen
import com.typez.keyboard.app.uix.settings.pages.AdvancedParametersScreen
import com.typez.keyboard.app.uix.settings.pages.AlreadyPaidDialog
import com.typez.keyboard.app.uix.settings.pages.BlacklistScreen
import com.typez.keyboard.app.uix.settings.pages.BlacklistScreenLite
import com.typez.keyboard.app.uix.settings.pages.CreditsScreen
import com.typez.keyboard.app.uix.settings.pages.CreditsScreenLite
import com.typez.keyboard.app.uix.settings.pages.themes.CustomThemeScreen
import com.typez.keyboard.app.uix.settings.pages.DevEditTextVariationsScreen
import com.typez.keyboard.app.uix.settings.pages.DevKeyboardScreen
import com.typez.keyboard.app.uix.settings.pages.DevLayoutEdit
import com.typez.keyboard.app.uix.settings.pages.DevLayoutEditor
import com.typez.keyboard.app.uix.settings.pages.DevLayoutList
import com.typez.keyboard.app.uix.settings.pages.DevThemeImportScreen
import com.typez.keyboard.app.uix.settings.pages.DeveloperScreen
import com.typez.keyboard.app.uix.settings.pages.HelpMenu
import com.typez.keyboard.app.uix.settings.pages.HomeScreen
import com.typez.keyboard.app.uix.settings.pages.HomeScreenLite
import com.typez.keyboard.app.uix.settings.pages.KeyboardAndTypingScreen
import com.typez.keyboard.app.uix.settings.pages.KeyboardSettingsMenu
import com.typez.keyboard.app.uix.settings.pages.LanguageSettingsLite
import com.typez.keyboard.app.uix.settings.pages.LanguagesScreen
import com.typez.keyboard.app.uix.settings.pages.LongPressMenu
import com.typez.keyboard.app.uix.settings.pages.MiscMenu
import com.typez.keyboard.app.uix.settings.pages.NumberRowSettingMenu
import com.typez.keyboard.app.uix.settings.pages.PaymentScreen
import com.typez.keyboard.app.uix.settings.pages.PaymentThankYouScreen
import com.typez.keyboard.app.uix.settings.pages.PredictiveTextMenu
import com.typez.keyboard.app.uix.settings.pages.ProjectInfoView
import com.typez.keyboard.app.uix.settings.pages.ResizeMenuLite
import com.typez.keyboard.app.uix.settings.pages.ResizeScreen
// import com.typez.keyboard.app.uix.settings.pages.SearchScreen  // Temporarily disabled
import com.typez.keyboard.app.uix.settings.pages.SelectLanguageScreen
import com.typez.keyboard.app.uix.settings.pages.SelectLayoutsScreen
import com.typez.keyboard.app.uix.settings.pages.themes.ThemeScreen
import com.typez.keyboard.app.uix.settings.pages.TypingSettingsMenu
import com.typez.keyboard.app.uix.settings.pages.VoiceInputMenu
import com.typez.keyboard.app.uix.settings.pages.addModelManagerNavigation
import com.typez.keyboard.app.uix.settings.pages.buggyeditors.BuggyTextEditVariations
// import com.typez.keyboard.app.uix.settings.pages.pdict.ConfirmDeleteExtraDictFileDialog  // Temporarily disabled
// import com.typez.keyboard.app.uix.settings.pages.pdict.PersonalDictionaryLanguageList  // Temporarily disabled
// import com.typez.keyboard.app.uix.settings.pages.pdict.PersonalDictionaryLanguageListForLocale  // Temporarily disabled
// import com.typez.keyboard.app.uix.settings.pages.pdict.WordPopupDialogF  // Temporarily disabled
import com.typez.keyboard.app.uix.settings.pages.themes.DeleteCustomThemeDialog
import com.typez.keyboard.app.uix.urlDecode
import com.typez.keyboard.app.uix.urlEncode

// Utility function for quick error messages
fun NavHostController.navigateToError(title: String, body: String) {
    this.navigate("error/${title.urlEncode()}/${body.urlEncode()}")
}

fun NavHostController.navigateToInfo(title: String, body: String) {
    this.navigate("info/${title.urlEncode()}/${body.urlEncode()}")
}

val SettingsMenus = listOf(
    HomeScreenLite,
    LanguageSettingsLite,
    KeyboardSettingsMenu,
    NumberRowSettingMenu,
    TypingSettingsMenu,
    ResizeMenuLite,
    LongPressMenu,
    PredictiveTextMenu,
    BlacklistScreenLite,
    VoiceInputMenu,
    ActionsScreen,
    HelpMenu,
    MiscMenu,
    CreditsScreenLite,
    IMESettingsMenu
) + AllActions.mapNotNull { it.settingsMenu } + SettingsByLanguage.values

@Composable
fun SettingsNavigator(
    navController: NavHostController = rememberNavController()
) {
    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(
            navController = navController,
            startDestination = "home",
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
            composable("home") { HomeScreen(navController) }
            // composable("search") { SearchScreen(navController) }  // Temporarily disabled
            composable("languages") { LanguagesScreen(navController) }
            composable("addLanguage") { SelectLanguageScreen(navController) }
            composable("addLayout/{lang}") {
                SelectLayoutsScreen(
                    navController,
                    it.arguments?.getString("lang")?.urlDecode() ?: ""
                )
            }
            // composable("pdict") {  // Temporarily disabled
            //     PersonalDictionaryLanguageList()
            // }
            // composable("pdict/{lang}") {  // Temporarily disabled
            //     PersonalDictionaryLanguageListForLocale(
            //         navController,
            //         it,
            //         it.arguments?.getString("lang")?.urlDecode() ?: "all"
            //     )
            // }
            // dialog("pdictword/{lang}/{word}") {  // Temporarily disabled
            //     WordPopupDialogF(
            //         locale = it.arguments?.getString("lang")?.urlDecode(),
            //         selectedWord = it.arguments?.getString("word")?.urlDecode(),
            //     )
            // }
            // dialog("pdictdelete/{dict}") {  // Temporarily disabled
            //     ConfirmDeleteExtraDictFileDialog(it.arguments?.getString("dict")?.urlDecode()!!)
            // }
            composable("advancedparams") { AdvancedParametersScreen(navController) }
            composable("actionEdit") { ActionEditorScreen(navController) }
            SettingsMenus.filterIsInstance<org.futo.inputmethod.latin.uix.settings.UserSettingsMenu>().filter { it.settings.isNotEmpty() }.forEach { menu ->
                if(menu.registerNavPath) composable(menu.navPath) { UserSettingsMenuScreen(menu) }
            }
            composable("keyboardAndTyping") { KeyboardAndTypingScreen(navController) }
            composable("resize") { ResizeScreen(navController) }
            composable("themes") { ThemeScreen(navController) }
            composable("customTheme/{uri}") { CustomThemeScreen(it.arguments?.getString("uri") ?: "", navController) }

            composable("developer") { DeveloperScreen(navController) }
            composable("devtextedit") { DevEditTextVariationsScreen(navController) }
            composable("devbuggytextedit") { BuggyTextEditVariations(navController) }
            composable("devlayouts") { DevLayoutList(navController) }
            composable("devlayouteditor") { DevLayoutEditor(navController) }
            composable("devtheme") { DevThemeImportScreen(navController) }
            composable("devkeyboard") { DevKeyboardScreen(navController) }
            composable("devlayoutedit/{i}") {
                DevLayoutEdit(
                    navController,
                    it.arguments!!.getString("i")!!.toInt()
                )
            }
            composable("blacklist") { BlacklistScreen(navController) }
            composable("payment") { PaymentScreen(navController) { navController.navigateUp() } }
            composable("paid") { PaymentThankYouScreen { navController.navigateUp() } }
            composable("credits") { CreditsScreen(navController) }
            composable("exportingcfg") { ExportingMenu(navController) }
            dialog("deleteTheme/{name}") {
                DeleteCustomThemeDialog(it.arguments?.getString("name")?.urlDecode() ?: "", navController)
            }
            composable("credits/thirdparty/{idx}") {
                ProjectInfoView(
                    it.arguments?.getString("idx")?.toIntOrNull() ?: 0,
                    navController
                )
            }
            dialog("error/{title}/{body}") {
                ErrorDialog(
                    it.arguments?.getString("title")?.urlDecode()
                        ?: stringResource(R.string.settings_unknown_error_title),
                    it.arguments?.getString("body")?.urlDecode()
                        ?: stringResource(R.string.settings_unknown_error_subtitle),
                    navController
                )
            }
            dialog("info/{title}/{body}") {
                InfoDialog(
                    it.arguments?.getString("title")?.urlDecode() ?: "",
                    it.arguments?.getString("body")?.urlDecode() ?: "",
                    navController
                )
            }
            dialog("update") {
                UpdateDialog(navController = navController)
            }
            dialog("alreadyPaid") {
                AlreadyPaidDialog(navController = navController)
            }
            addModelManagerNavigation(navController)
        }
    }
}
