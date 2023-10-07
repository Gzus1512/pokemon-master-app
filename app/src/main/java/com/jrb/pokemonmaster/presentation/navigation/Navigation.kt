package com.jrb.pokemonmaster.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.jrb.pokemonmaster.presentation.screens.DashboardScreen
import com.jrb.pokemonmaster.presentation.screens.DetailsScreen
import com.jrb.pokemonmaster.presentation.viewmodel.PokemonViewModel

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Routes.MainNavGraph.route) {
        navigation(
            route = Routes.MainNavGraph.route,
            startDestination = Routes.Dashboard.route
        ) {
            composable(Routes.Dashboard.route) {
                val viewModel =
                    it.sharedViewModel<PokemonViewModel>(navController = navController)
                LaunchedEffect(key1 = true) {
                    if (viewModel.viewState.pokemonList.isEmpty()) viewModel.init()
                }
                DashboardScreen(
                    viewModel.viewState
                ) {pokemonDetails ->
                    navController.navigate(Routes.Details.createRoute(pokemonDetails.name)) {
                        navController.currentDestination?.route?.let { route ->
                            popUpTo(route)
                        }
                    }
                }
            }
            composable(
                route = Routes.Details.route,
                arguments = listOf(navArgument(NavArgs.ItemId.key) {
                    type = NavType.StringType
                })
            ) {
                val viewModel =
                    it.sharedViewModel<PokemonViewModel>(navController = navController)
                DetailsScreen(
                    viewModel.viewState,
                    it.arguments?.getString(NavArgs.ItemId.key)
                )
                {
                    navController.popBackStack()
                }
            }
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }

    return hiltViewModel(parentEntry)
}