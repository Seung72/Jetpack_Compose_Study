package com.cholee.e03_box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cholee.e03_box.ui.theme.E03_BoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Column() {
                    Text("Hi!", modifier = Modifier
                        .padding(16.dp))
                    Box(modifier = Modifier
                        .background(color = Color.Black)
                        .padding(16.dp)
                        .fillMaxWidth(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Text("Cholee", color = Color.White)
                    }
                    Box(modifier = Modifier
                        .background(color = Color.Blue)
                        .padding(16.dp)
                        .fillMaxWidth(),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Text("Bye!")
                    }
                }

            }
        }
    }
}
