package com.example.hw2greeting

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw2greeting.ui.theme.HW2GreetingTheme
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Greeting(modifier = Modifier)
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var (textValue, setText) = remember { mutableStateOf("") }
    val onTextChange = { newText: String ->
        setText(newText)
    }
    Column {
        TextField(
            value = textValue,
            onValueChange = onTextChange,
            label = { Text("Enter your name") },
            modifier = Modifier.padding(16.dp)
        )

        var pressed by remember { mutableStateOf(false) }
        Button(onClick = { pressed = !pressed }, modifier = Modifier.padding(16.dp)){
            Text(text = "Submit")
        }

        if (pressed) {
            val time = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

            if (textValue.isNotEmpty()) {
                Text(text = "Hello, $textValue!", modifier = Modifier.padding(16.dp))
                val hour = time.substring(0, 2).toInt()
                if (6 <= hour && hour < 12) {
                    Text(text = "Good morning!", modifier = Modifier.padding(16.dp))
                } else if (12 <= hour && hour < 18) {
                    Text(text = "Good afternoon!", modifier = Modifier.padding(16.dp))
                } else if (18 <= hour && hour < 24){
                    Text(text = "Good evening!", modifier = Modifier.padding(16.dp))
                } else {
                    Text(text = "Good night!", modifier = Modifier.padding(16.dp))
                }
            }
        }

    }




}



@Preview(showBackground = true)
@Composable
fun Preview() {

}