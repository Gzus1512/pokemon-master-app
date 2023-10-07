package com.jrb.pokemonmaster.data.remote.service

import com.jrb.pokemonmaster.data.remote.dto.PokemonDataDto
import com.jrb.pokemonmaster.data.remote.dto.PokemonResponseDto
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiClient {
    @GET("pokemon")
    suspend fun getPokemonList(): PokemonResponseDto

    @GET
    suspend fun getPokemonData(@Url url: String): PokemonDataDto
}
