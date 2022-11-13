package com.ksi.examplecompose.presentation.coin_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ksi.examplecompose.presentation.Screen
import com.ksi.examplecompose.presentation.coin_list.component.CoinListItem

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinsListViewModel = hiltViewModel()
) {
 val stat=viewModel.state.value
   Box(modifier = Modifier.fillMaxSize()) {
       LazyColumn(modifier = Modifier.fillMaxSize() ){
           items(stat.coins){coin->
               CoinListItem(coin = coin, onItemClick =
               {
                   navController.navigate(Screen.CoinDetailScreen.route+"/${coin.id}")
               }
               )

           }
       }
       if(stat.error.isNullOrBlank()){
           Text(
               text = stat.error,
               color = MaterialTheme.colors.error,
               textAlign = TextAlign.Center,
               modifier = Modifier.fillMaxWidth()
           )
       }
       if(stat.isLoading){
          CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
       }
   }
}