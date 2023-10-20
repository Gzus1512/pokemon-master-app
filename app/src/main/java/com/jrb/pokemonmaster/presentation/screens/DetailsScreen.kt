package com.jrb.pokemonmaster.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jrb.pokemonmaster.R
import com.jrb.pokemonmaster.domain.model.PokemonDataModel
import com.jrb.pokemonmaster.presentation.RoundedImageView
import com.jrb.pokemonmaster.presentation.viewmodel.ViewState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    viewState: ViewState,
    pokemonName: String?,
    navBack: () -> Unit
) {
    pokemonName?.let { name ->
        if (viewState.pokemonList.isNotEmpty()){
            val pokemonData = viewState.pokemonList.first { pokemonData ->
                pokemonData.name == name
            }
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(name)
                        },
                        navigationIcon = {
                            IconButton(
                                onClick = { navBack() }
                            ) {
                                Icon(Icons.Default.ArrowBack, contentDescription = Icons.Default.ArrowBack.name)
                            }
                        }
                    )
                },
                content = { paddingValues ->
                    Box(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            RoundedImageView(
                                image = pokemonData.imageUrl,
                                modifier = Modifier.size(200.dp)
                            )
                            Text(text = "${stringResource(id = R.string.pokemon_height_text)} ${pokemonData.height}")
                            Text(text = "${stringResource(id = R.string.pokemon_weight_text)} ${pokemonData.weight}")
                            Text(text = stringResource(id = R.string.pokemon_types_text))
                            pokemonData.types.forEach{
                                Text(text = it)
                            }
                        }
                    }
                }
            )
        } else {
            GoBackButton {
                navBack()
            }
        }
    } ?: run {
        GoBackButton {
            navBack()
        }
    }
}

@Composable
fun GoBackButton(
    navBack: () -> Unit
) {
    Button(onClick = { navBack() }) {
        Text(text = "Go back")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetails() {
    val viewState = ViewState(
        pokemonList = listOf(
            PokemonDataModel(
                name = "Bulbasaur",
                imageUrl = "",
                weight = "43",
                height = "7",
                types = listOf(
                    "fire", "wind"
                )
            ),
            PokemonDataModel(
                name = "Bulbasaur",
                imageUrl = "",
                weight = "43",
                height = "7",
                types = listOf(
                    "fire", "wind"
                )
            )
        )
    )
    DetailsScreen(
        viewState,
        "Bulbasaur"
    ) {

    }
}
