package com.example

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.myapplication.APICommunication
import io.ktor.websocket.Frame
import java.nio.file.WatchEvent

@Composable
fun PlanetDetailScreen(planet: APICommunication.Planet) {
    Column(modifier = WatchEvent.Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Name: ${planet.name}", style = MaterialTheme.typography.h4)
        Frame.Text(text = "Orbital Period: ${planet.orbital_period}")
        Text(text = "Gravity: ${planet.gravity}")
    }
}
