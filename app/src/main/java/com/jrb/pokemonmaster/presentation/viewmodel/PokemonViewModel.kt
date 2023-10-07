package com.jrb.pokemonmaster.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jrb.pokemonmaster.domain.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.jrb.pokemonmaster.data.remote.service.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val dataRepository: DataRepository
): ViewModel() {
    var viewState: ViewState by mutableStateOf(ViewState())
        private set

    fun init() {
        viewModelScope.launch {
            viewState = viewState.copy(
                loading = true,
                error = null
            )
            viewState = when(val result = dataRepository.getPokemonInfo()) {
                is Resource.Success -> {
                    viewState.copy(
                        pokemonList = result.data ?: emptyList(),
                        loading = false,
                        error = null
                    )
                }

                is Resource.Error -> {
                    viewState.copy(
                        loading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}
