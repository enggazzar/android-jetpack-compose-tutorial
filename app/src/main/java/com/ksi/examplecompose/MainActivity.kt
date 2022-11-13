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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ksi.examplecompose.ui.theme.ExampleComposeTheme
import com.ksi.examplecompose.ui.theme.defaultPadding
import java.util.Collections.list

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        how drow
        1- compose
        2- layout measer places
        3- draw
         */
        /*
        life cycle
        1- compose
        2- recompose or more item
        3- leave
         */
        setContent {
            ExampleComposeTheme {
                // A surface container using the 'background' color from the theme
                //hoistable state remove dublicate state

                Surface(color = MaterialTheme.colors.background) {
                    val viewModel=viewModel<MainViewModel>()
                    val state=viewModel.state

                      LazyColumn(modifier = Modifier.fillMaxSize() ){
                          items(state.items.size){ i->
                              if(i>=state.items.size-1&&!state.isLoading&&!state.endReach){
                                  viewModel.loadNextItem()
                              }
                              val item=state.items[i]
                              Column(modifier = Modifier
                                  .fillMaxWidth()
                                  .padding(20.dp)) {
                                  Text(text = item.title)
                                  Text(text = item.description)
                              }

                          }
                          item {
                              if(state.isLoading){
                                  Row(horizontalArrangement = Arrangement.Center,modifier=Modifier.fillMaxSize()) {
                                      CircularProgressIndicator()
                                  }

                              }
                          }
                      }
                }
            }
        }
    }



}