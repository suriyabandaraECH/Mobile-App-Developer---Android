package com.example

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigator(viewModel: PlanetViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "planetList") {
        composable("planetList") {
            PlanetListScreen(viewModel) { planet ->
                viewModel.selectPlanet(planet)
                navController.navigate("planetDetail")
            }
        }
        composable("planetDetail") {
            val selectedPlanet by viewModel.selectedPlanet.collectAsState()
            selectedPlanet?.let { PlanetDetailScreen(it) }
        }
    }
}
