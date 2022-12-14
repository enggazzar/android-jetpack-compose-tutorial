package com.ksi.examplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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


 */
val defaultPadding=24.dp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleComposeTheme {

                Surface(color = MaterialTheme.colors.background) {
                   MyApp()


                 /*   Text(
                        text = "vv",
                        style = inputButton.copy(color = if (true) Color.Red else Color.Green)
                    )*/

                   // MyApp()
                }
            }
        }
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


