package com.jrb.pokemonmaster.data.remote.dto

import com.squareup.moshi.Json

data class PokemonDto(
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "url") val url: String?
)
