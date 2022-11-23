package com.ksi.examplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

1- routing 2- no fragment 3- visibilty  4- no more getvalue from  text 5-
1- routing 2- no fragment 3- visibilty 4- no more getvalue from text 5- coil 6- no adapter  7- main layout column row box
 */
val defaultPadding=24.dp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleComposeTheme {

                Surface(color = MaterialTheme.colors.background) {
                    MarginUsingOrderPadding()

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


