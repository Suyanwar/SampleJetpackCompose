package com.suyanwar.samplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.suyanwar.samplecompose.ui.theme.Blue10
import com.suyanwar.samplecompose.ui.theme.Green20
import com.suyanwar.samplecompose.ui.theme.SampleComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    FullScreen()
                }
            }
        }
    }
}

@Composable
fun EditTextScreen(onTextChange: (TextFieldValue) -> Unit) {
    var text by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Blue10),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
                onTextChange(newText)
            },
            textStyle = TextStyle(fontSize = 24.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Composable
fun ResultScreen(text: TextFieldValue) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Green20)
    ) {
        Text(
            text = text.text,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun FullScreen() {
    var text by remember { mutableStateOf(TextFieldValue()) }
    Box(contentAlignment = Alignment.Center) {
        Column {
            Row(modifier = Modifier
                .weight(1.0f)
                .fillMaxWidth()) {
                EditTextScreen(onTextChange = { newText ->
                    text = newText
                })
            }

            Row(modifier = Modifier
                .weight(1.0f)
                .fillMaxWidth()) {
                ResultScreen(text = text)
            }
        }
    }
}

@Preview
@Composable
fun FullScreenPreview() {
    FullScreen()
}