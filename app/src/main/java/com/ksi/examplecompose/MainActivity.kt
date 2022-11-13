package com.ksi.examplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RestrictTo
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ksi.examplecompose.ui.theme.ExampleComposeTheme
import com.ksi.examplecompose.ui.theme.defaultPadding
import kotlinx.coroutines.*
import java.util.Collections.list

/*
primary color usually background for exampl appbar bg onPrimary usually text on background of primary
example
appBar bg=primarycolor
content=onPrimary
 */
class MainActivity : ComponentActivity() {
    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ExampleComposeTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(onNavigationItemClick = {
                            scope.launch { // launch a new coroutine in background and continue
                                scaffoldState.drawerState.open()
                            }
                        })
                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(items = itemsMenu, onClickItem =
                        {
                            when (it.id) {
                                "setting" -> print(it.title)
                                "Home" -> print(it.title)
                            }
                        }
                        )
                    }) {

                }
            }
        }

    }
}

val itemsMenu = listOf(
    MenuItem("Home", "Home", Icons.Default.Home),
    MenuItem("Setting", "Setting", Icons.Default.Settings)
)