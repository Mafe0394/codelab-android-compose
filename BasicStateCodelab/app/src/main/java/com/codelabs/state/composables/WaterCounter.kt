package com.codelabs.state.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelabs.state.ui.theme.BasicStateCodelabTheme

@Composable
fun StatefulWaterCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableIntStateOf(0) }
    StatelessWaterCounter(modifier = modifier, count = count) { count++ }
}

@Composable
fun StatelessWaterCounter(
    modifier: Modifier = Modifier,
    count: Int,
    onIncrement: () -> Unit
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        NormalButton(
            modifier = Modifier.padding(top = 8.dp),
            enabled = count < 10,
            text = "Add one",
            onClick = onIncrement
        )
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun PreviewWellnessTaskItem() {
    BasicStateCodelabTheme {
        StatefulWaterCounter()
    }
}
