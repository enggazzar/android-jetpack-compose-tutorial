package com.ksi.examplecompose.data.repository


import com.ksi.examplecompose.data.remote.CoinPaprikaApi
import com.ksi.examplecompose.data.remote.dto.CoinDetailDto
import com.ksi.examplecompose.data.remote.dto.CoinDto
import com.ksi.examplecompose.domain.repository.CoinRepository
import javax.inject.Inject

/**
 *
 *
 * 19/04/2022
 */
class CointRepositoryImp @Inject constructor(private val api: CoinPaprikaApi): CoinRepository {

  override suspend fun getCoins(): List<CoinDto> {
   return api.getCoins()
  }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
      return api.getCoinById(coinId = coinId)
    }

}