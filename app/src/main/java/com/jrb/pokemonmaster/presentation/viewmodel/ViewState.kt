package com.jrb.pokemonmaster.presentation.viewmodel

import com.jrb.pokemonmaster.domain.model.PokemonDataModel

data class ViewState(
    val pokemonList: List<PokemonDataModel> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)
