package com.ksi.examplecompose.di


import com.ksi.examplecompose.data.NetworkModule
import com.ksi.examplecompose.data.remote.CoinPaprikaApi
import com.ksi.examplecompose.data.repository.CointRepositoryImp
import com.ksi.examplecompose.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module(includes = [NetworkModule::class])

//how long will left and mean here stay as long app exist
@InstallIn(SingletonComponent::class)
object AppModule {
    //provide function
    @Provides
    @Singleton
    fun providePaprikaApi(retrofit: Retrofit): CoinPaprikaApi {
        return retrofit.create(CoinPaprikaApi::class.java)

    }
  //provide mean when take instance of object return
    //provide used tell can inject class like from libs
    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CointRepositoryImp(api)

    }
    /*
     @Singleton
    @Provides
    fun provideTrendingApi(retrofit: Retrofit): TrendingService {
        return retrofit.create(TrendingService::class.java)
    }

    @Singleton
    @Provides
    fun provideTrendingRepository(trendingService: TrendingService): TrendingRepository {
        return TrendingRepositoryImpl(trendingService)
    }
     */
}