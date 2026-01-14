package com.typez.keyboard.app.uix.settings.pages

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import com.typez.keyboard.app.uix.settings.pages.modelmanager.FinetuneModelScreen
import com.typez.keyboard.app.uix.settings.pages.modelmanager.ModelDeleteConfirmScreen
import com.typez.keyboard.app.uix.settings.pages.modelmanager.ModelListScreen
import com.typez.keyboard.app.uix.settings.pages.modelmanager.ModelScreenNav
import com.typez.keyboard.app.uix.settings.pages.modelmanager.PrivateModelExportConfirmation
import com.typez.keyboard.app.uix.urlDecode
import java.io.File

fun NavGraphBuilder.addModelManagerNavigation(
    navController: NavHostController
) {
    composable("models") { ModelListScreen(navController) }
    composable("finetune/{modelPath}") {
        val path = it.arguments!!.getString("modelPath")!!.urlDecode()
        FinetuneModelScreen(
            File(path), navController
        )

    }
    composable("finetune") {
        FinetuneModelScreen(file = null, navController = navController)
    }
    composable("model/{modelPath}") {
        val path = it.arguments!!.getString("modelPath")!!.urlDecode()
        ModelScreenNav(
            File(path), navController
        )
    }
    dialog("modelExport/{modelPath}") {
        PrivateModelExportConfirmation(
            File(it.arguments!!.getString("modelPath")!!.urlDecode()),
            navController
        )
    }
    dialog("modelDelete/{modelPath}") {
        val path = it.arguments!!.getString("modelPath")!!.urlDecode()
        ModelDeleteConfirmScreen(File(path), navController)
    }
}
