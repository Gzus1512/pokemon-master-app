package com.jrb.pokemonmaster.data.remote.dto

import com.squareup.moshi.Json

data class SpriteDto(
    @field:Json(name = "front_default") val imageUrl: String?
)
