package com.ksi.examplecompose
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.ksi.examplecompose.ui.theme.ExampleComposeTheme
import com.ksi.examplecompose.ui.theme.customTitle
import com.ksi.examplecompose.ui.theme.defaultPadding
import java.util.Collections.list
/*
==================================
Imperative programming vs Declarative programming
Imperative UI
This is the most common paradigm. It involves having a separate prototype/model of the application’s UI. This design focuses on the how rather than the what. A good example is XML layouts in Android. We design the widgets and components which are then rendered for the user to see and interact with
==================================
Declarative UI
This pattern is an emerging trend that allows the developers to design the user interface based on the data received. This on the other hand focuses on the what. This design paradigm makes use of one programming language to create an entire application.
 ================================
 Advantages of JetPack Compose
It is very fast and offers a smooth performance.

It’s simple to learn.

It is possible to interoperate with an imperative approach.

Offers a better way to implement loose coupling principles.

It is 100% made in Kotlin which makes it a modern approach in Android development
======================================
 Arrangement
We also have three arrangements that can be applied as vertical and horizontal arrangements:

SpaceEvenly [ a a a ]

SpaceBetween [a a a]

SpaceAround
=======================================
There are nine alignment options that can apply to child UI elements
TopStart  TopCenter  Top End
CenterStart   Center CenterEnd
BottomStart     BottomCenter  BottomEnd
=====================================
Typography:
From MaterialTheme, we can reuse the default typography. They customize the textstyle() with various text sizes
=======================================
What are Modifiers in Jetpack Compose?
 Modifier elements decorate or add behavior to Compose UI elements. For example, backgrounds, padding and click event listeners decorate or add behavior to rows, text or buttons.

We can give size and spacing with the help of modifiers.

Arrange the widgets within a layout.

Beautify the widgets.

If you are an Android developer,
Most of the xml attributes (id, padding, margin, color, alpha, ratio, elevation...) are used with the help of modifiers
 =============================================
 Available shapes in Jetpack Compose:
RectangleShape
CircleShape
RoundedCornerShape
CutCornerShape
you can check https://www.jetpackcompose.net/buttons-in-jetpack-compose
==================================
mutableState -  It return an observable value for Compose. If value changed UI get changed
=========================================
LazyRow(
   verticalArrangement = Arrangement.spacedBy(4.dp),
) {
    // ...
}
=====================
What is state in jetpack compose?
A state is an object it can hold our data. If data changes happen, it will update all its subscribed
UI widgets. If you want to update the data at runtime in your widgets, you can use the state object.
 */


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleComposeTheme {
                // A surface container using the 'background' color from the theme
                //hoistable state remove dublicate state
                val gradient =
                    Brush.horizontalGradient(listOf(Color(0xFF28D8A3), Color(0xFF00BEB2)))
                Surface(color = MaterialTheme.colors.primary) {
                   Column(modifier = Modifier.background(gradient)) {

                       IconButton(onClick = {  },
                           modifier = Modifier
                               .clip(CircleShape)
                               .border(1.dp, androidx.compose.ui.graphics.Color.Red, shape = CircleShape)


                       ) {
                           Icon(Icons.Default.Add, contentDescription = "content description",tint = androidx.compose.ui.graphics.Color.Red)
                       }

                       //1. Text Size
                       Text("hh", fontSize = 10.sp, style = MaterialTheme.typography.customTitle)
                       //text color
                       Text("Color text", color = androidx.compose.ui.graphics.Color.Blue)
                       //Bold Text
                       Text("Bold text", fontWeight = FontWeight.Bold)
                       //italic
                       Text("Italic Text", fontStyle = FontStyle.Italic)
                       //max line
                       Text("hello ".repeat(50), maxLines = 2)
                       //text overflow
                       Text("Hello Compose ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
                       //Selectable Text
                       SelectionContainer {
                           Text("This text is selectable")
                       }

                       //style
                       Text(
                           text = "Hello World",
                           style = TextStyle(
                               color = androidx.compose.ui.graphics.Color.Red,
                               fontSize = 16.sp,
                               fontFamily = FontFamily.Monospace,
                               fontWeight = FontWeight.W800,
                               fontStyle = FontStyle.Italic,
                               letterSpacing = 0.5.em,
                               background = androidx.compose.ui.graphics.Color.Blue,
                               textDecoration = TextDecoration.Underline
                           )
                       )
                       //shadow
                       Text(
                           text = "Text with Shadow",
                           style = TextStyle(
                               shadow = Shadow(
                                   color = androidx.compose.ui.graphics.Color.Blue,
                                   offset = Offset(5f, 5f),
                                   blurRadius = 5f
                               )
                           )
                       )
                          //decoration
                       Text(
                           text = "Text with Underline",
                           style = TextStyle(
                               color =  androidx.compose.ui.graphics.Color.Black, fontSize = 24.sp,
                               textDecoration = TextDecoration.Underline
                           )
                       )
                      //padding
                       Text(
                           "Padding and margin!",
                           Modifier.padding(32.dp) // Outer padding (margin)
                               .background(color = androidx.compose.ui.graphics.Color.Green) //background color
                               .padding(16.dp) // Inner padding
                       )
                       //modifier

                   }
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    //remeberSeverabale save value even configer of app changed
    var onBoard by remember {
        mutableStateOf(true)
    }
    if(onBoard){
        OnboardingScreen({onBoard=false})
    }else{
        Greetings()
    }

}
@Composable
fun Greetings(names: List<String> =List(1000){"$it"}){
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(defaultPadding)) {
            LazyColumn {
                items(names){name->
                    Greeting(name = name)
                    
            }
              
            }
        }
    }
}
@Composable
fun Greeting(name:String){
    //remember to save last value when recompose happened
    //mutablestate will recompose element depond on this value
    //by to delegate
    var expand by remember {  mutableStateOf(false)}


   val expandValue=if(expand) 34.dp else 0.dp
    Surface(color = MaterialTheme.colors.primary,modifier = Modifier.padding(horizontal = 8.dp ,vertical = 8.dp)) {
      Row(modifier = Modifier
          .padding(defaultPadding)) {
          Column(modifier = Modifier
              .weight(0.1f)
              .padding(bottom = expandValue)) {
              Text(text = "Hello ")
              Text(text = "$name!")
          }
          OutlinedButton(onClick = { expand=!expand }) {
              Text( if (expand) stringResource(R.string.cc) else "Show More")
          }
      }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExampleComposeTheme {
       // MyApp()
        OnboardingScreen({})
    }
}
@Composable
fun OnboardingScreen(onContenueClicked:()->Unit) {
    // TODO: This state should be hoisted
   // var shouldShowOnboarding by remember { mutableStateOf(true) }

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContenueClicked
            ) {
                Text("Continue")
            }
        }
    }
}
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    ExampleComposeTheme {
        OnboardingScreen({})
    }
}