package com.typez.keyboard.app.uix.actions

import android.content.Intent
import com.typez.keyboard.app.R
import com.typez.keyboard.app.uix.Action
import com.typez.keyboard.app.uix.settings.SettingsActivity

val SettingsAction = Action(
    icon = R.drawable.settings,
    name = R.string.go_to_settings,
    simplePressImpl = { manager, _ ->
        val intent = Intent()
        intent.setClass(manager.getContext(), SettingsActivity::class.java)
        intent.setFlags(
            Intent.FLAG_ACTIVITY_NEW_TASK
                    or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
                    or Intent.FLAG_ACTIVITY_CLEAR_TOP
        )
        manager.getContext().startActivity(intent)
    },
    windowImpl = null,
)
