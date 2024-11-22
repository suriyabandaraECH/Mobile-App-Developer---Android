package com.example

import androidx.lifecycle.ViewModel
import com.example.myapplication.APICommunication
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlanetViewModel : ViewModel() {
    private val _planets = MutableStateFlow<List<APICommunication.Planet>>(emptyList())
    val planets: StateFlow<List<APICommunication.Planet>> get() = _planets

    private val _selectedPlanet = MutableStateFlow<APICommunication.Planet?>(null)
    val selectedPlanet: StateFlow<APICommunication.Planet?> get() = _selectedPlanet

    init {
        fetchPlanets()
    }

    private fun fetchPlanets() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val data = APICommunication.ApiClient.fetchPlanets()
                _planets.value = data
            } catch (e: Exception) {
                // Handle errors here
            }
        }
    }

    fun selectPlanet(planet: APICommunication.Planet) {
        _selectedPlanet.value = planet
    }
}
