package com.jrb.pokemonmaster.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jrb.pokemonmaster.domain.model.PokemonDataModel
import com.jrb.pokemonmaster.presentation.ItemView
import com.jrb.pokemonmaster.presentation.viewmodel.ViewState

@Composable
fun DashboardScreen(
    viewState: ViewState,
    navToDetails: (pokemonData: PokemonDataModel) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            !viewState.error.isNullOrEmpty() -> {
                Text(
                    text = viewState.error,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            viewState.pokemonList.isNotEmpty() -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(viewState.pokemonList) { pokemonData ->
                        ItemView(
                            name = pokemonData.name,
                            imageUrl = pokemonData.imageUrl,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navToDetails(pokemonData)
                                }
                                .padding(horizontal = 16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDashboard() {
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
    DashboardScreen(
        viewState
    ) {

    }
}
