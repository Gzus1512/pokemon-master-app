package com.jrb.pokemonmaster.data.remote.service

import com.jrb.pokemonmaster.data.remote.dto.PokemonDataDto
import com.jrb.pokemonmaster.data.remote.dto.PokemonResponseDto
import retrofit2.http.GET

interface ApiClient {
    @GET
    suspend fun getPokemonList(): PokemonResponseDto

    @GET
    suspend fun getPokemonData(): PokemonDataDto
}
