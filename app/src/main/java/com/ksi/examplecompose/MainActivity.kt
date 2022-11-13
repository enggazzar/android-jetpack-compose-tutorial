package com.ksi.examplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ksi.examplecompose.ui.theme.ExampleComposeTheme
import com.ksi.examplecompose.ui.theme.defaultPadding
import java.util.Collections.list
/*
coupling class a and b depend to each other is bad practice
solid
s->single responsibility
class should have one responsibilty and have one reason to change
benifits
1- easy testing
2- lower coupling
3-easy to understand-clean code
4- code organized
5- if function have problem will not effect another if all function in smae class
o->open close (software entities (classes,module,functions)
should be open for extention close for modification
l->liskov substitution
if s is asubtype of t then objects of type t in aprogram may be replaced with object of type s
without altering any of the desirsble properites of that programe

i-> Interface segregation(seperate)
splite large interfce to small interface
so client know only about methods they need
d->dependency inversion العكسى
high level module and low model both should depend on abstration
abstraction should not depend on details but concret class have details




 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleComposeTheme {
                // A surface container using the 'background' color from the theme
                //hoistable state remove dublicate state

                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
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