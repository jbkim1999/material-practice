package com.example.materialpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.materialpractice.model.HeroesRepository
import com.example.materialpractice.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            HeroTopBar()
                        }
                    ) {it ->
                        HeroesList(
                            heroes = HeroesRepository.heroes,
                            contentPadding = it,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun HeroScreenPreview() {
    SuperheroesTheme {
        Scaffold(
            topBar = {
                HeroTopBar()
            }
        ) {it ->
            HeroesList(
                heroes = HeroesRepository.heroes,
                contentPadding = it
            )
        }
    }
}
