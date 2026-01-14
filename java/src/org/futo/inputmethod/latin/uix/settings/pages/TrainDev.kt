package com.typez.keyboard.app.uix.settings.pages

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.typez.keyboard.app.uix.getSettingFlow
import com.typez.keyboard.app.uix.settings.ScreenTitle
import com.typez.keyboard.app.uix.settings.ScrollableList
import com.typez.keyboard.app.xlm.HistoryLogForTraining
import com.typez.keyboard.app.xlm.NUM_TRAINING_RUNS_KEY
import com.typez.keyboard.app.xlm.TrainingState
import com.typez.keyboard.app.xlm.TrainingStateWithModel
import com.typez.keyboard.app.xlm.TrainingWorkerStatus
import com.typez.keyboard.app.xlm.loadHistoryLogBackup
import com.typez.keyboard.app.xlm.scheduleTrainingWorkerImmediately
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TrainDevScreen(navController: NavHostController = rememberNavController()) {
    var trainingDataAmount by remember { mutableIntStateOf(0) }
    val trainingState = TrainingWorkerStatus.state.collectAsState(initial = TrainingStateWithModel(TrainingState.None, null))

    val progress = TrainingWorkerStatus.progress.collectAsState(initial = 0.0f)
    val loss = TrainingWorkerStatus.loss.collectAsState(initial = Float.MAX_VALUE)

    val context = LocalContext.current
    LaunchedEffect(Unit) {
        val data = mutableListOf<HistoryLogForTraining>()
        loadHistoryLogBackup(context, data)

        trainingDataAmount = data.size
    }

    val numTrains = context.getSettingFlow(NUM_TRAINING_RUNS_KEY, 0).collectAsState(initial = 0)

    ScrollableList {
        ScreenTitle("Training", showBack = true, navController)

        Text("The model has been trained ${numTrains.value} times in total.")

        Text("There are $trainingDataAmount pending training examples (minimum for training is 100)")

        Button(onClick = {
            scheduleTrainingWorkerImmediately(context)
        }, enabled = (!TrainingWorkerStatus.isTraining.value) && (trainingDataAmount >= 100)) {
            if(TrainingWorkerStatus.isTraining.value) {
                Text("Currently training (${(progress.value * 100.0f).roundToInt()}%, loss ${loss.value})")
            } else if(trainingDataAmount > 100) {
                Text("Train model")
            } else {
                Text("Train model (not enough data)")
            }
        }

        when(trainingState.value.state) {
            TrainingState.Finished -> Text("Last train finished successfully! Final loss: ${loss.value}")
            TrainingState.ErrorInadequateData -> Text("Last training run failed due to lack of data")
            else -> { }
        }
    }
}
