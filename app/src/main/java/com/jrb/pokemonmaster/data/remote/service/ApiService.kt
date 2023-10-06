package com.jrb.pokemonmaster.data.remote.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiService @Inject constructor(
    private val api: ApiClient
)
{
    suspend fun getPokemonList() =
        callServiceCoordinator {
            val pokemonList = api.getPokemonList()
        }

    suspend fun getPokemonData() =
        callServiceCoordinator {
            val pokemonData = api.getPokemonData()
        }

    private suspend fun <T> callServiceCoordinator(
        call: suspend () -> T
    ): Resource<T> = withContext(Dispatchers.IO) {
        try {
            Resource.Success(call())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}
