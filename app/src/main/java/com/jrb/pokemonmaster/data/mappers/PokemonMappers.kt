package com.jrb.pokemonmaster.data.mappers

import com.jrb.pokemonmaster.data.remote.dto.PokemonDataDto
import com.jrb.pokemonmaster.data.remote.dto.TypeListDto
import com.jrb.pokemonmaster.domain.model.PokemonDataModel

fun PokemonDataDto.toPokemonDataModel() = PokemonDataModel(
    name ?: "",
    sprites?.imageUrl ?: "",
    weight ?: "",
    height ?: "",
    getTypes(types)
)

fun getTypes(typesDto: List<TypeListDto>): List<String> {
    val typeList: ArrayList<String> = arrayListOf()
    typesDto.forEach { typeDto ->
        typeList.add(
            typeDto.type.typeName ?: ""
        )
    }
    return typeList
}
