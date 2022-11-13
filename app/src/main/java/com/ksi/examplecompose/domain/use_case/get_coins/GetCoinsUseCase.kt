package com.ksi.examplecompose.domain.use_case.get_coins

import com.ksi.examplecompose.common.Resource
import com.ksi.examplecompose.data.remote.dto.toCoin
import com.ksi.examplecompose.domain.model.Coin
import com.ksi.examplecompose.domain.repository.CoinRepository

import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
/**
 *
 *
 * 19/04/2022
 */
/*
Dependency injection means giving an object its instance variables. So pretty much just passing constructor arguments instead of creating the arguments in the class itself. That can either be done manually or by a library like Dagger-Hilt.
-----------------
why use case [handel bussinss logic]
1-if there are commen api you will repeat logic viewmodel so remove dublicate code
2- understand project feature (name scream )
3- bussiness logic and rules
----------
domain
reposity have fun will get data and have no idea about source so can provide fake data
usecases
----data layer
repositry impl
----
dto data transfer object (data from server )
di dependancy injection

can be repository:CoinRepository=CoinRepositoryimp()
but will be constant
 */
class GetCoinsUseCase @Inject constructor(private  val repository: CoinRepository) {
  //cal it like function bcz we use operator
  operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
    try {
      emit(Resource.Loading<List<Coin>>())
      val coins = repository.getCoins().map { it.toCoin() }
      emit(Resource.Success<List<Coin>>(coins))
    } catch(e: HttpException) {
      emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
    } catch(e: IOException) {
      emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
    }
  }

}