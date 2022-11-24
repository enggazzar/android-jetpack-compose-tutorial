package com.ksi.examplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter
import com.ksi.examplecompose.ui.theme.ExampleComposeTheme
import com.ksi.examplecompose.ui.theme.customTitle
import com.ksi.examplecompose.ui.theme.dropdownText
import com.ksi.examplecompose.ui.theme.inputButton
import java.util.Collections.list

/*
https://material.io/design/color/the-color-system.html#tools-for-picking-colors
  <!-- Status bar color. -->
        <item name="android:statusBarColor" tools:targetApi="l">?attr/colorPrimaryVariant</item>
        only one we need to change from xml theme file
        https://developer.android.com/reference/kotlin/androidx/compose/material/Colors
https://stackoverflow.com/questions/45879513/what-is-the-difference-between-colorprimary-and-colorprimarydark-in-themes
https://developer.android.com/reference/kotlin/androidx/compose/material/Typography

1- No more margin but we Have order padding to make margin
2-Main layout (Row-Column-Box)
3-No more visibilty gone ()
4- load image (coil)
5- No more adapter and rv(Lazy row-Lazy column)
6- No more getText
7-Navigation


 */
val defaultPadding = 24.dp

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ExampleComposeTheme {

        Surface(color = MaterialTheme.colors.background) {
          ExampleVisibility()
        }
      }
    }
  }
}

//no margin in compose but padding using for both according to order
//margin add padding before background and size
@Preview()
@Composable
fun MarginUsingOrderPadding() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .alpha(0.7f)
      .background(Color.Black)
  ) {
    Text(
      text = "Welcome", color = Color.White,
      modifier = Modifier
        // .alpha(0.7f)
        // //margin
        .padding(20.dp)
        . //margin
        background(Color.Red)
        .padding(5.dp)
    )
  }
}



@Preview()
@Composable
fun Row() {

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
fun Column() {
  Column(
    modifier = Modifier
      .fillMaxSize()
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
fun Box() {
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
@Preview()
@Composable
fun ExampleVisibility() {
  var showText by remember { mutableStateOf(true) }

  Column(modifier = Modifier
    .fillMaxSize()
    .padding(20.dp))

  {
    if (showText) {
      Text(text = "Welcome", color = Color.Green)
    }
    Button(onClick = { showText = !showText }) {
      Text(text = "Toggle Visibility", color = Color.White)
    }
  }
}
@OptIn(ExperimentalCoilApi::class)
@Preview()
@Composable
fun ExampleCoil() {

  val painter =rememberImagePainter(data = "https://images.unsplash.com/photo-1628373383885-4be0bc0172fa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1301&q=80")

  Column(modifier = Modifier
    .fillMaxSize()
    .padding(20.dp))

  {
    Image(
      painter = painter,
      contentDescription = "Forest Image",
      modifier = Modifier
        .width(90.dp)
        .height(90.dp),
      contentScale = ContentScale.Crop
    )
  }
}
@Preview()
@Composable
fun ExampleLazyColumn() {
  LazyColumn(modifier = Modifier
    .fillMaxSize()
    .padding(20.dp)) {


    items(items) { item->
     RowA(item =item )
    }

    item { MyApp() }

    items(items) { item->
      RowA(item =item )
    }
  }


}

@Composable
fun RowA(item: myIcon) {
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
  Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
    //style

    Text(text = "inputButton", style = inputButton)
    Text(text = "body", style = MaterialTheme.typography.body1)
    Text(text = "customTitle", style = MaterialTheme.typography.customTitle)
    Text(text = "dropdownText", style = dropdownText(Color.Red))
    //====color========//
    Text(text = "color red", color = Color.Red)
    Text(text = "colors.primary", color = MaterialTheme.colors.primary)
    //===shape==================//
    Box(
      modifier = Modifier
        .size(100.dp)
        .clip(MaterialTheme.shapes.medium)
        .background(Color.Red)
    )
  }
}


