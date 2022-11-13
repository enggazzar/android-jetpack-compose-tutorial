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
https://www.youtube.com/watch?v=EOQB8PTLkpY&t=219s
compose phases
1- compose
2- layout
3- draw
1-donot make operation list of lazy column make it in viewmode or with rememmber
example
lazy column(){
items(contacts.sortby())
{
}
----------
2-provide key muste be key
lazy column(){
items(contacts,key=it.id)
{
}
3-derive state of to remebr state of lazy column like remeber is first item showing
val lazySatet=remeberlazylistsate()
lazyColumn(state=lazySatet){
val showButton by remeber{
lazystate.firstItemIndex>0
{
4-dever read state changed will call Text only when contact value changed
mycard(contact)
{
Text("$contant.name")
}
5- running backwards [calculate bal;ance in view model before call compose]
val balance by remeber{mutablestateOf(0)}
for(transaction in transactions)
{
Row(){
balance+=tranaction
Text("balance")
//donot do this

}
6- baseline profile
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