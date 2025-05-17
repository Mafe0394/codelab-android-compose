package com.codelabs.state.composables

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NormalButton(
    modifier: Modifier = Modifier,
    enabled: Boolean,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled
    ) { Text(text) }
}
