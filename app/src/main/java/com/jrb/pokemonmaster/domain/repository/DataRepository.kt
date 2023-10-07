package com.jrb.pokemonmaster.domain.repository

import com.jrb.pokemonmaster.data.remote.service.Resource
import com.jrb.pokemonmaster.domain.model.PokemonDataModel

interface DataRepository {
    suspend fun getPokemonInfo(): Resource<List<PokemonDataModel>>
}