package com.codelabs.state.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codelabs.state.data.WellnessTask

@Composable
private fun WellnessTaskItem(
    taskName: String,
    modifier: Modifier,
    onClose: () -> Unit,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = taskName,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange
        )
        IconButton(
            onClose,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Close"
            )
        }
    }
}

@Composable
fun WellnessTaskItem(task: WellnessTask, modifier: Modifier = Modifier, onClose: () -> Unit) {
    var isChecked by rememberSaveable { mutableStateOf(false) }
    WellnessTaskItem(
        taskName = task.label,
        isChecked = isChecked,
        onCheckedChange = { isChecked = it },
        onClose = onClose,
        modifier = modifier
    )
}
