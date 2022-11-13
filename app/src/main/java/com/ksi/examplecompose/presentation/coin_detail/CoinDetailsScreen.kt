package com.ksi.examplecompose.presentation.coin_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.ksi.examplecompose.presentation.coin_detail.components.CoinTag
import com.ksi.examplecompose.presentation.coin_detail.components.TeamListItem

@Composable
fun CoinDetailScreen(viewModel:CoinDetailViewModel= hiltViewModel()){
    val state=viewModel.state
    Box(modifier = Modifier.fillMaxSize()) {
        state.value.coin?.let { coin->
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp) ){
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                        Text(
                            text = "${coin.rank}.${coin.name}(${coin.symbol})",
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier.weight(8f)
                        )
                        Text(
                            text = if (coin.isActive) "Active" else "not Active",
                            color = if (coin.isActive) Color.Green else Color.Black,
                            textAlign = TextAlign.End,
                            modifier = Modifier.align(CenterVertically)
                        )
                    }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text ="Tag",
                            style = MaterialTheme.typography.h6,
                            color = Color.Black

                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        FlowRow (
                            mainAxisSpacing = 10.dp,
                            crossAxisSpacing = 10.dp
                        ){
                         coin.tags.forEach { tag->
                             CoinTag(tag = tag)
                         }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text ="Team Member",
                            style = MaterialTheme.typography.h6,
                            color = Color.Black

                        )

                }
               items(coin.team){ team->
                 TeamListItem(teamMember = team,modifier = Modifier.fillParentMaxWidth())
                   Divider()
               }
                

            }
        }
        if(state.value.error.isNullOrBlank()){
            Text(
                text = state.value.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        if(state.value.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        
    }

}