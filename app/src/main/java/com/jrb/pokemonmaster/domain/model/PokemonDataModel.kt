package com.jrb.pokemonmaster.domain.model

data class PokemonDataModel(
    val name: String,
    val imageUrl: String,
    val weight: String,
    val height: String,
    val types: List<String>
)
