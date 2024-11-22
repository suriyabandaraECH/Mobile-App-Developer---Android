package com.example

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.APICommunication

@Composable
fun PlanetListScreen(viewModel: PlanetViewModel, onPlanetClick: (APICommunication.Planet) -> Unit) {
    val planets by viewModel.planets.collectAsState()

    LazyColumn {
        items(planets) { planet ->
            PlanetCard(planet, onClick = { onPlanetClick(planet) })
        }
    }
}

@Composable
fun PlanetCard(planet: APICommunication.Planet, onClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp).clickable { onClick() }) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = planet.name, style = MaterialTheme.typography.h6)
            Text(text = "Climate: ${planet.climate}")
        }
    }
}
