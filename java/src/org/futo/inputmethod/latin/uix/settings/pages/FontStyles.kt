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
                .fillMaxWidth()
                .padding(16.dp, 8.dp)
        ) {
            Text(stringResource(R.string.font_styles_open_wordstyles))
        }

        Spacer(Modifier.height(24.dp))

        Text(
            text = stringResource(R.string.font_styles_available_styles),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp, 8.dp)
        )

        VerticalGrid(
            items = listOf(
                R.string.action_fonttyper_preset_title_superhero,
                R.string.action_fonttyper_preset_title_candy,
                R.string.action_fonttyper_preset_title_dramatictext,
                R.string.action_fonttyper_preset_title_rainbow,
                R.string.action_fonttyper_preset_title_horizon,
                R.string.action_fonttyper_preset_title_opening_crawl,
                R.string.action_fonttyper_preset_title_scratch,
                R.string.action_fonttyper_preset_title_calligraphy,
                R.string.action_fonttyper_preset_title_times_new_roman,
                R.string.action_fonttyper_preset_title_not_sans,
                R.string.action_fonttyper_preset_title_monospace,
                R.string.action_fonttyper_preset_title_comic_sans,
                R.string.action_fonttyper_preset_title_gothic,
                R.string.action_fonttyper_preset_title_cursive,
                R.string.action_fonttyper_preset_title_typewriter,
                R.string.action_fonttyper_preset_title_neon,
                R.string.action_fonttyper_preset_title_retro,
                R.string.action_fonttyper_preset_title_elegant
            ),
            columns = 2,
            modifier = Modifier.padding(16.dp, 0.dp)
        ) { fontNameRes ->
            Text(
                text = stringResource(fontNameRes),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
