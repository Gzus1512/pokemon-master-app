package com.jrb.pokemonmaster.di

import com.jrb.pokemonmaster.data.remote.service.ApiClient
import com.jrb.pokemonmaster.data.remote.service.ApiService
import com.jrb.pokemonmaster.data.repository.DataRepositoryImpl
import com.jrb.pokemonmaster.domain.repository.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokemonApi(): ApiClient {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideApiService(api: ApiClient): ApiService {
        return ApiService(api)
    }

    @Provides
    @Singleton
    fun provideDataRepository(apiService: ApiService): DataRepository {
        return DataRepositoryImpl(apiService)
    }

}
