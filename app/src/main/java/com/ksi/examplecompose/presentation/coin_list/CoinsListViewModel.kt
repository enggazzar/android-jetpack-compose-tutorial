package com.ksi.examplecompose.presentation.coin_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ksi.examplecompose.common.Resource
import com.ksi.examplecompose.domain.use_case.get_coins.GetCoinsUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 *
 *
 * 19/04/2022
 */
@HiltViewModel
class CoinsListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase):ViewModel() {
 //not want axis out side view model
  private val _state = mutableStateOf(CoinListState())
  val state: State<CoinListState> = _state
  init {
    getCoins()
  }

   fun getCoins() {
    Log.e("gt","lll")
    //cal it like function bcz we use operator
    getCoinsUseCase().onEach { result ->
      when (result) {
        is Resource.Success -> {
          _state.value = CoinListState(coins = result.data ?: emptyList())
        }
        is Resource.Error -> {
          Log.e("gt",result.message ?: "An unexpected error occured")

          _state.value = CoinListState(
            error = result.message ?: "An unexpected error occured"
          )
        }
        is Resource.Loading -> {
          Log.e("gt","loading")

          _state.value = CoinListState(isLoading = true)
        }
      }
    }.launchIn(viewModelScope)
  }
}