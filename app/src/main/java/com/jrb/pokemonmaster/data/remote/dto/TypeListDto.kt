package com.jrb.pokemonmaster.data.remote.dto

import com.squareup.moshi.Json

data class TypeListDto(
    @field:Json(name = "type") val type: List<TypeDto>
)
