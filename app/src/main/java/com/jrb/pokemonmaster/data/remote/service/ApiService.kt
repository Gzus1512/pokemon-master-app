package com.jrb.pokemonmaster.data.remote.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiService (
    private val api: ApiClient
)
{
    suspend fun getPokemonList() =
        callServiceCoordinator {
            api.getPokemonList()
        }

    suspend fun getPokemonData(name: String) =
        callServiceCoordinator {
            val url = "pokemon/${name}"
            api.getPokemonData(url)
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
