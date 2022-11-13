package com.ksi.examplecompose.data.remote

import com.ksi.examplecompose.data.remote.dto.CoinDetailDto
import com.ksi.examplecompose.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 *
 * 19/04/2022
 */
interface CoinPaprikaApi {
 @GET("v1/coins")
 suspend fun getCoins():List<CoinDto>
 @GET("/v1/coins/{coinId}")
 suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}