package com.jrb.pokemonmaster.data.remote.dto

import com.squareup.moshi.Json

data class TypeDto(
    @field:Json(name = "name") val typeName: String?
)
