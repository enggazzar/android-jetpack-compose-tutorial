package com.ksi.examplecompose

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource

@Composable
fun AppBar(onNavigationItemClick:()->Unit){
    TopAppBar (title = { Text(text = stringResource(id = R.string.app_name))
    },
      backgroundColor = colorResource(id = R.color.purple_200),
      contentColor = Color.Red,
      navigationIcon = {
          IconButton(onClick =onNavigationItemClick) {
              Icon(imageVector = Icons.Default.Menu, contentDescription = null)
              
          }
      }  

    )
}