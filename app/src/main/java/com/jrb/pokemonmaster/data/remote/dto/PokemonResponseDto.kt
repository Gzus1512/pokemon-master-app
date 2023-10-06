package com.jrb.pokemonmaster.data.remote.dto

import com.squareup.moshi.Json

data class PokemonResponseDto(
    @field:Json(name = "results") val pokemonList: List<PokemonDto>
)
