package com.jrb.pokemonmaster.data.repository

import com.jrb.pokemonmaster.data.mappers.toPokemonDataModel
import com.jrb.pokemonmaster.data.remote.service.ApiService
import com.jrb.pokemonmaster.data.remote.service.Resource
import com.jrb.pokemonmaster.domain.model.PokemonDataModel
import com.jrb.pokemonmaster.domain.repository.DataRepository

class DataRepositoryImpl(
    private val api: ApiService
) : DataRepository
{
    override suspend fun getPokemonInfo(): Resource<List<PokemonDataModel>> {
        return when (val response = api.getPokemonList()) {
            is Resource.Success -> {
                val pokemonDataList: ArrayList<PokemonDataModel> = arrayListOf()
                response.data?.pokemonList?.filter{
                    it.url != null
                }?.forEach { pokemonDto ->
                    val pokemonData = api.getPokemonData(pokemonDto.name!!)
                    if (pokemonData is Resource.Success) {
                        pokemonData.data?.let {
                            pokemonDataList.add(pokemonData.data.toPokemonDataModel())
                        }
                    }
                }
                Resource.Success(
                    data = pokemonDataList.toList()
                )
            }
            is Resource.Error -> {
                Resource.Error(response.message ?: "An unknown error occurred.")
            }
        }
    }
}
