package com.ksi.examplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ksi.examplecompose.ui.theme.ExampleComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleComposeTheme {
                // A surface container using the 'background' color from the theme
                //hoistable state remove dublicate state
               // mySurface()

                mBottomAppBar()
            }
        }
    }

    //note content alingment  arrange child
    @Composable
    fun mySurface() {
        Surface(
            color = MaterialTheme.colors.primary,
            shape = CutCornerShape(15.dp),

            modifier = Modifier
                .size(250.dp)
                .padding(10.dp),
            border = BorderStroke(5.dp, Color.Black),
            elevation = 22.dp
        ) {
            mPadding()
        }
    }

    @Composable
    fun mContentAlignment() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            contentAlignment = Alignment.Center

        ) {
            Box(
                modifier = Modifier
                    .size(300.dp, 300.dp)
                    .background(Color.White),
                contentAlignment = Alignment.TopCenter

            ) {
                Text(text = "Welcome", color = Color.Blue)
            }
        }
    }

    //no margin in compose but padding using for both according to order
    //margin add padding befor background and size
    @Composable
    fun mPadding() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.7f)
                .background(Color.Black)
        ) {
            Text(
                text = "Welcome", color = Color.Blue,
                modifier = Modifier
                    .alpha(0.7f)
                    .
                        // clip(CutCornerShape(10.dp)).
                    padding(20.dp)
                    . //margin
                    background(Color.Red)
                    .padding(10.dp)
                    . //padding
                    background(Color.Cyan)
                    .border(10.dp, color = Color.Blue, RoundedCornerShape(2.dp))
            )
        }
    }
    //button type 1- button 2- out line button 3-text button 4- icon button
    //any button need text inside

    @Composable
    fun mButton() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Button")
            }
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "OutlinedButton")
            }
            TextButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.ExitToApp,
                    contentDescription = "",
                    tint = Color.Black
                )
                Text(text = "TextButton")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.ExitToApp,
                    contentDescription = "",
                    tint = Color.Black
                )
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.Red
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.ExitToApp,
                    contentDescription = "",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.size(30.dp))
                Text(text = "Button")
            }
        }
    }

    //button shape
    @Composable
    fun mButtonShape() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(topStart = 10.dp)) {
                Text(text = "Button")
            }
            Button(onClick = { /*TODO*/ }, shape = CircleShape, modifier = Modifier.size(60.dp)) {
                Text(text = "Button")
            }
        }
    }

    //Image have clib with shape to add border
    //give border shape like clip
    @Composable
    fun mImageWithShape() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.mipmap.flowers),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .border(width = 2.dp, shape = RoundedCornerShape(10.dp), color = Color.Red)
            )
        }
    }

    //scafold know position of
    //topBar botton navigate -drawer
    @Composable
    fun myScaffold() {
        Scaffold(
            topBar = {
                TopAppBar() {
                    Text(text = "topBar")
                }
            },
            bottomBar = {
                BottomAppBar() {
                    Text(text = "bottom bar")
                }
            },
            content = {
                mText()
            }

        )
    }

    //scafold BottomAppBar used for modile 5 screen with floating action button
    //buttom navigation 3 to 5 screen mobile and tablet
    @Preview
    @Composable
    fun mBottomAppBar() {
        var bottomStae by remember {
            mutableStateOf("Home")

        }
        Scaffold(
            
            bottomBar = {
            BottomNavigation() {
                BottomNavigationItem(
                    selected = bottomStae == "Home",
                    onClick = { bottomStae = "Home" },
                    label = { Text(text = "Home") },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.ExitToApp,
                            contentDescription = "",
                            tint = Color.White
                        )
                    })
                BottomNavigationItem(
                    selected = bottomStae == "Account",
                    onClick = { bottomStae = "Account" },
                    label = { Text(text = "Account") },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Call,
                            contentDescription = "",
                            tint = Color.White
                        )
                    })
                BottomNavigationItem(
                    selected = bottomStae == "Exit",
                    onClick = { bottomStae = "Exit" },
                    label = { Text(text = "Exit") },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "",
                            tint = Color.White
                        )
                    })
            }
        }

        ) {
            Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
                Text(text = bottomStae,fontSize = 25.sp)
                
            }

        }

    }

    @Composable
    fun mText() {
        Text(
            text = "welcome", color = Color.Green, modifier = Modifier.padding(10.dp)
        )
    }


    @Composable
    fun mainPreview() {
        myScaffold()
    }
}





