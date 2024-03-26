package com.example.boaviagem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.boaviagem.ui.theme.BoaViagemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoaViagemTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetContent()
                }
            }
        }
    }
}

@Composable
fun SetContent(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginActivity(navController = navController)
        }
        composable("main") {
            GetMain(navController = navController)
        }
    }
}

@Composable
fun GetMain(navController: NavController){
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "LOGADO COM USUÁRIO ROOT")
        GetButtonComponentMain(navController = navController)
    }
}

@Composable
fun GetButtonComponentMain(navController: NavController){
    Button(onClick = {
            navController.navigate("login")
    },
        Modifier.size(width = 200.dp, height = 50.dp)) {
        Text(text = "Logout")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BoaViagemTheme {
    }
}