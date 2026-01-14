package com.typez.keyboard.app.uix.actions

import com.typez.keyboard.app.R
import com.typez.keyboard.app.Subtypes
import com.typez.keyboard.app.uix.Action


val SwitchLanguageAction = Action(
    icon = R.drawable.globe,
    name = R.string.show_language_switch_key,
    simplePressImpl = { manager, _ ->
        if(!Subtypes.switchToNextLanguage(manager.getContext(), 1)) {
            manager.openInputMethodPicker()
        }
    },
    altPressImpl = { manager, _ ->
        manager.openInputMethodPicker()
    },
    windowImpl = null,
)
