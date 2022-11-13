package com.ksi.examplecompose.domain.repository

import com.ksi.examplecompose.data.remote.dto.CoinDetailDto
import com.ksi.examplecompose.data.remote.dto.CoinDto


/**
 *
 *
 * 19/04/2022
 */
interface CoinRepository {
  suspend fun getCoins():List<CoinDto>
  suspend fun getCoinById(coinId: String): CoinDetailDto

}