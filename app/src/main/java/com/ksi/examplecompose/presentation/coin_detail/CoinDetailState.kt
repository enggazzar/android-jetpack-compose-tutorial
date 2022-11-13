package com.ksi.examplecompose.presentation.coin_detail

import com.ksi.examplecompose.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)