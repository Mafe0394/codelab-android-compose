package com.codelabs.state.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codelabs.state.data.WellnessTask
import com.codelabs.state.data.WellnessTasksList
import com.codelabs.state.domain.WellnessViewModel

@Composable
fun WellnessScreen(modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column {
        StatefulWaterCounter()
        WellnessTasksList(
            taskList = wellnessViewModel.tasks,
            onCloseTask = { task -> wellnessViewModel.removeTask(task) },
            onCheckedChanged = {task -> wellnessViewModel.changeTaskChecked(task) }
        )
    }
}