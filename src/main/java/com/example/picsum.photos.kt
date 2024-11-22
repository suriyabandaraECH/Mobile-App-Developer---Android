package com.example

import android.text.Layout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.myapplication.APICommunication
import io.ktor.http.ContentType
import java.lang.reflect.Modifier

@Composable
fun PlanetCardWithImage(planet: APICommunication.Planet, onClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp).clickable { onClick() }) {
        Row(verticalAlignment = Layout.Alignment.CenterVertically) {
            ContentType.Image(
                painter = rememberImagePainter("https://picsum.photos/100"),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = planet.name, style = MaterialTheme.typography.h6)
                Text(text = "Climate: ${planet.climate}")
            }
        }
    }
}
