package com.ksi.examplecompose.presentation.coin_list

import com.ksi.examplecompose.domain.model.Coin


/**
 *
 *
 * 19/04/2022
 */
data class CoinListState(val isLoading: Boolean = false,
                         val coins: List<Coin> = emptyList(),
                         val error: String = "")
