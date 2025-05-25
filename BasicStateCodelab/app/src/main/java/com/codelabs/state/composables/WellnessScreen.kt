package com.codelabs.state.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import com.codelabs.state.data.WellnessTask
import com.codelabs.state.data.WellnessTasksList

fun getWellnessTaskList(): List<WellnessTask> = List(31) { WellnessTask(it, "Task # $it") }

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column {
        val list = remember { getWellnessTaskList().toMutableStateList() }
        StatefulWaterCounter()
        WellnessTasksList(taskList = list, onCloseTask = { task -> list.remove(task) })
    }
}