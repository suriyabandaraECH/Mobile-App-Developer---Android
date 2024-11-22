package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient
import io.ktor.client.
import io.ktor.client.call.
import io.ktor.client.request.
import io.ktor.client.plugins.contentnegotiation.
import io.ktor.serialization.kotlinx.json.
import kotlinx.serialization.Serializable

class APICommunication : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a_p_i_communication, container, false)
    }

    object ApiClient {
        private val client = HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }

        suspend fun fetchPlanets(): List<Planet> {
            val response: PlanetResponse = client.get("https://swapi.dev/api/planets/")
            return response.results
        }
    }

    @Serializable
    data class PlanetResponse(val results: List<Planet>)

    @Serializable
    data class Planet(val name: String, val climate: String, val orbital_period: String, val gravity: String)
}
