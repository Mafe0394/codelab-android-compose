package com.codelabs.state.data

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codelabs.state.composables.WellnessTaskItem

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    taskList: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedChanged: (WellnessTask) -> Unit
) {
    LazyColumn {
        items(
            taskList,
            key = { it.id }) { task ->
            WellnessTaskItem(
                task = task,
                modifier = modifier,
                onClose = { onCloseTask(task) },
                onCheckedChange = { onCheckedChanged(task) },
                isChecked = task.checked
            )
        }
    }
}