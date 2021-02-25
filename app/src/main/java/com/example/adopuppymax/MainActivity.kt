package com.example.adopuppymax

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adopuppymax.ui.theme.AdopuppymaxTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainComponent()
        }
    }
}

@Composable
fun MainComponent() {
    AdopuppymaxTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Greeting("Android")
        }
    }
}

@Composable
fun ContainerFun(content: @Composable () -> Unit) {
    AdopuppymaxTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = Color.Cyan) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = Color.Cyan) {
        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
    }
}

@Composable
fun MyScreenContent() {
    Column {
        Greeting("Android")
        Divider(color = Color.Black)
        Greeting("there")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AdopuppymaxTheme {
        Greeting("Android!!!")
    }
}

@Composable
fun MyScreenContentList(names: List<String> = listOf("Android", "there")) {
    Column {
        for (name in names) {
            Greeting(name = name)
            Divider(color = Color.Black)
        }
    }
}

@Composable
fun Counter() {
    val count = remember { mutableStateOf(0) }
    Button(onClick = { count.value++ }) {
        Text("I've been clicked ${count.value} times")
    }
}

@Composable
fun MyScreenContentCounter(names: List<String> = listOf("Android", "there")) {
    Column {
        for (name in names) {
            Greeting(name = name)
            Divider(color = Color.Black)
        }
        Divider(color = Color.Transparent, thickness = 32.dp)
        Counter()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewT() {
    AdopuppymaxTheme {
        MyScreenContentCounter(listOf("1", "2"))
    }
}
