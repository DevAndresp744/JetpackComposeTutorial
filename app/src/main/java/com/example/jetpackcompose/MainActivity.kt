package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TutorialImage(title = getString(R.string.title ), firstParagraph = getString(R.string.firstParagraph), secondParagraph = getString(
                        R.string.secondParagraph
                    ))
                }
            }
        }
    }
}

@Composable
fun TutorialImage(title: String, firstParagraph: String, secondParagraph: String , modifier: Modifier = Modifier){

    val image = painterResource(id = R.drawable.bg_compose_background,
   )

    Column(
        verticalArrangement = Arrangement.Center,
    ){
        Image(painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            alpha = 10F,
        )

        TutorialText(title = title,
            firstParagraph = firstParagraph,
            secondParagraph = secondParagraph,
            modifier = Modifier
                .fillMaxSize()
                .padding()

        )

    }


}

@Composable
fun TutorialText(title: String, firstParagraph: String, secondParagraph: String , modifier: Modifier = Modifier){

    Column(
        verticalArrangement = Arrangement.Center,
              )
    {
        Text(text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.Start)
        )

        Text(text = firstParagraph,
            modifier = Modifier
                .padding(start=16.dp, end = 16.dp)
                .align(alignment = Alignment.Start)
        )
        Text(text = secondParagraph,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.Start),
            textAlign = TextAlign.Justify

        )
    }

}

@Preview(showBackground = true)
@Composable
fun TutorialPreview() {
    JetpackComposeTheme {

        TutorialImage(
            title = "Jetpack Compose tutorial",
            firstParagraph = "Jetpack Compose is a modern toolkit for building native Android UI. " +
                    "Compose simplifies and accelerates UI development on Android with less code, " +
                    "powerful tools, and intuitive Kotlin APIs.",
            secondParagraph = "In this tutorial, you build a simple UI component with declarative functions. " +
                    "You call Compose functions to say what elements you want and the Compose compiler does the rest. " +
                    "Compose is built around Composable functions. These functions let you define your app's " +
                    "UI programmatically because they let you describe how it should look and provide data dependencies, " +
                    "rather than focus on the process of the UI's construction, such as initializing an element " +
                    "and then attaching it to a parent. To create a Composable function, " +
                    "you add the @Composable annotation to the function name.")
        }
}