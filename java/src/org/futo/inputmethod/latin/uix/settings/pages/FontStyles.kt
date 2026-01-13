package org.futo.inputmethod.latin.uix.settings.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.futo.inputmethod.latin.R
import org.futo.inputmethod.latin.uix.LocalManager
import org.futo.inputmethod.latin.uix.settings.ScrollableList
import org.futo.inputmethod.latin.uix.actions.fonttyper.FontTyperAction
import org.futo.inputmethod.latin.uix.actions.fonttyper.PresetPicker
import org.futo.inputmethod.latin.uix.settings.Tip
import org.futo.inputmethod.latin.uix.settings.UserSetting
import org.futo.inputmethod.latin.uix.settings.pages.VerticalGrid

@Composable
fun FontStylesScreen(navController: NavController) {
    val manager = LocalManager.current
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    ScrollableList(modifier = Modifier.verticalScroll(scrollState)) {
        Text(
            text = stringResource(R.string.font_styles_title),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp, 8.dp)
        )

        Text(
            text = stringResource(R.string.font_styles_description),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp, 0.dp)
        )

        Spacer(Modifier.height(16.dp))

        if (manager?.appSupportsImageInsertion("image/png", true) == false) {
            Tip("⚠ " + stringResource(R.string.action_fonttyper_app_unsupported_warning))
        }

        Button(
            onClick = {
                manager?.forceActionWindowAboveKeyboard(true)
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(stringResource(R.string.action_fonttyper_show_font_styles))
        }

        PresetPicker()

        Spacer(Modifier.height(16.dp))

        VerticalGrid(
            items = listOf(
                UserSetting(
                    title = R.string.font_styles_antique,
                    subtitle = null,
                    icon = null,
                    key = "font_antique",
                    default = { false },
                    onChange = { }
                ),
                UserSetting(
                    title = R.string.font_styles_cool,
                    subtitle = null,
                    icon = null,
                    key = "font_cool",
                    default = { false },
                    onChange = { }
                ),
                UserSetting(
                    title = R.string.font_styles_retro,
                    subtitle = null,
                    icon = null,
                    key = "font_retro",
                    default = { false },
                    onChange = { }
                ),
                UserSetting(
                    title = R.string.font_styles_scratch,
                    subtitle = null,
                    icon = null,
                    key = "font_scratch",
                    default = { false },
                    onChange = { }
                ),
                UserSetting(
                    title = R.string.font_styles_superhero,
                    subtitle = null,
                    icon = null,
                    key = "font_superhero",
                    default = { false },
                    onChange = { }
                )
            ),
            columns = 2
        )
        }
    }
}
