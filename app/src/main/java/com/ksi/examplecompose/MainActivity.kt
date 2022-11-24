package com.ksi.examplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceAround
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ksi.examplecompose.ui.theme.ExampleComposeTheme
import com.ksi.examplecompose.ui.theme.defaultPadding
import java.util.Collections.list

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleComposeTheme {
                // A surface container using the 'background' color from the theme
                //hoistable state remove dublicate state

                Surface(color = MaterialTheme.colors.background) {
                  //  myScafold()
                    myLazyColumn()
                }
            }
        }
    }
}

@Composable
fun myTextField() {
    var textValue by remember {
        mutableStateOf("")
    }
    TextField(value = textValue, onValueChange = { text -> textValue = text },
        label = { Text(text = "this label") }
    )
}

@Composable
fun myOutLineTextField() {
    var textValue by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = textValue, onValueChange = { text -> textValue = text },
        label = { Text(text = stringResource(R.string.label)) },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = colorResource(id = R.color.purple_500),
            focusedBorderColor = colorResource(id = R.color.purple_700)
        )
    )
}

//onclick must send
@Composable
fun MyButton() {
    Button(onClick = { /*TODO*/ }
    )

    {
        Text(text = "Click Me")
    }
}

@Composable
fun myRadioGroup() {
    val radioButtons = listOf(0, 1, 2)

    var selectedxtedButton by remember {
        mutableStateOf(radioButtons.first())
    }
    val colors = RadioButtonDefaults.colors(
        selectedColor = colorResource(id = R.color.purple_500),
        unselectedColor = colorResource(id = R.color.black)
    )
    Column() {
        radioButtons.forEach { index ->
            val isSelected = index == selectedxtedButton
            RadioButton(selected = isSelected, onClick = { selectedxtedButton = index })
        }

    }
}

@Composable
fun myFloatingActionButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        content = { Text(text = "Fab") },
        contentColor = colorResource(id = R.color.purple_700)
    )


}

// horizontalArrangement = Arrangement.SpaceBetween order item  horizontal
@Composable
fun myRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(text = "one")
        Text(text = "tow")
        Text(text = "three")

    }
}

@Composable
fun myColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            //to make scroll
            .verticalScroll(rememberScrollState())
            .background(color = Color.Green)
    )
    // verticalArrangement = Arrangement.SpaceAround

    {
        Text(text = "one")
        Text(text = "tow")
        Text(text = "three")

    }
}

//box like frame layout
@Composable
fun myBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green)
    )
    // verticalArrangement = Arrangement.SpaceAround

    {
        Text(
            text = "one",
            modifier = Modifier.align(Alignment.TopStart)
        )
        Text(
            text = "tow",
            modifier = Modifier.align(Alignment.Center)
        )
        Text(
            text = "three",
            modifier = Modifier.align(Alignment.BottomEnd)
        )

    }
}
//contain only one element
//like root of app

@Composable
fun mySufuce() {
    Surface() {

    }
}

//scafold
//topbar compose function so give {}
@Composable
fun myScafold() {
    Scaffold(content = { myRow() },
        topBar = { myAppBar() }
    )


}

@Composable
fun myAppBar() {
    TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) }, navigationIcon = {
        IconButton(onClick = { /*TODO*/ },
            content = { Icon(imageVector = Icons.Default.Menu, contentDescription = "") })
    }
    )
}

@Composable
fun myLazyColumn() {
    LazyColumn() {
        items(items) { item->
             myRowA(item =item )
        }
    }

}

@Composable
fun myRowA(item: myIcon) {
    Row() {
        Image(
            painter = painterResource(id = item.icon), contentDescription = "",
            modifier = Modifier
                .size(70.dp)
                .padding(4.dp)
        )
        Text(text = item.name,modifier = Modifier.align(Alignment.CenterVertically))


    }

}
val items = listOf(
    myIcon(R.drawable.ic_launcher_background, "test1"),
    myIcon(R.drawable.ic_launcher_background, "test12")
)

data class myIcon(val icon: Int, val name: String)


@Composable
fun MyApp() {
    //remeberSeverabale save value even configer of app changed
    var onBoard by remember {
        mutableStateOf(true)
    }
    if (onBoard) {
        OnboardingScreen({ onBoard = false })
    } else {
        Greetings()
    }

}

@Composable
fun Greetings(names: List<String> = List(1000) { "$it" }) {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(defaultPadding)) {
            LazyColumn {
                items(names) { name ->
                    Greeting(name = name)

                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    //remember to save last value when recompose happened
    //mutablestate will recompose element depond on this value
    //by to delegate
    var expand by remember { mutableStateOf(false) }


    val expandValue = if (expand) 34.dp else 0.dp
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(defaultPadding)
        ) {
            Column(
                modifier = Modifier
                    .weight(0.1f)
                    .padding(bottom = expandValue)
            ) {
                Text(text = "Hello ")
                Text(text = "$name!")
            }
            OutlinedButton(onClick = { expand = !expand }) {
                Text(if (expand) stringResource(R.string.cc) else "Show More")
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
fun OnboardingScreen(onContenueClicked: () -> Unit) {
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