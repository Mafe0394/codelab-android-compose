package com.codelabs.state.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskItem(
    taskName: String,
    modifier: Modifier = Modifier,
    onClose: () -> Unit
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
