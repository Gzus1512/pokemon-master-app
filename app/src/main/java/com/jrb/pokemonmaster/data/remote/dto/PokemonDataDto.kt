package com.jrb.pokemonmaster.data.remote.dto

import com.squareup.moshi.Json

data class PokemonDataDto(
    @field:Json(name = "id") val id: String?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "height") val height: String?,
    @field:Json(name = "weight") val weight: String?,
    @field:Json(name = "sprites") val sprites: SpriteDto?,
    @field:Json(name = "types") val types: List<TypeListDto>
)
