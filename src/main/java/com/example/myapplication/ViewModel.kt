package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_model, container, false)
    }

    class PlanetViewModel : ViewModel() {
        private val _planets = MutableStateFlow<List<Planet>>(emptyList())
        val planets: StateFlow<List<Planet>> get() = _planets

        private val _selectedPlanet = MutableStateFlow<Planet?>(null)
        val selectedPlanet: StateFlow<Planet?> get() = _selectedPlanet

        init {
            fetchPlanets()
        }

        private fun fetchPlanets() {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val data = ApiClient.fetchPlanets()
                    _planets.value = data
                } catch (e: Exception) {
                    // Handle errors here
                }
            }
        }

        fun selectPlanet(planet: Planet) {
            _selectedPlanet.value = planet
        }
    }

}