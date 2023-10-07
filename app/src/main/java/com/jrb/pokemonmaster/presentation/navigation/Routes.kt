package com.jrb.pokemonmaster.presentation.navigation

sealed class Routes(val route: String) {
    object MainNavGraph : Routes("mainNavGraph")
    object Dashboard : Routes("dashboard")
    object Details : Routes("details/{${NavArgs.ItemId.key}}") {
        fun createRoute(name: String) =
            "details/${name}"
    }
}

enum class NavArgs(val key: String) {
    ItemId("itemId")
}