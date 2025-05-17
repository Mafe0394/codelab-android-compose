package com.codelabs.state.composables

import android.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelabs.state.ui.theme.BasicStateCodelabTheme

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var counter by remember { mutableIntStateOf(0) }
    var isClosed by remember { mutableStateOf(true) }
    Scaffold(
        modifier = modifier,
        snackbarHost = {
            if (counter > 0 || !isClosed) {
                if (!isClosed) {
                    WellnessTaskItem(
                        taskName = "Have you taken your 15 minute walk today?",
                        modifier = Modifier
                            .border(border = BorderStroke(color = colorResource(R.color.holo_green_dark), width = 2.dp))
                    ) {
                        isClosed = true
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues)
        ) {
            if (counter > 0) {
                if(counter == 1){
                    isClosed = false
                }
                Text(
                    text = "You've had $counter cups of water today"
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                NormalButton(
                    text = "Add a cup of water",
                    enabled = counter < 10
                ) {
                    counter++
                }
                NormalButton(
                    text = "Clear water counter",
                    enabled = true
                ) {
                    counter = 0
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWellnessTaskItem() {
    BasicStateCodelabTheme {
        WaterCounter()
    }
}
