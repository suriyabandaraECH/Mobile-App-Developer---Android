package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.AppNavigator
import dagger.hilt.android.AndroidEntryPoint

//package com.example.myapplication
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: ViewModel.PlanetViewModel by viewModels()
            AppNavigator(viewModel)
        }
    }
}

}
