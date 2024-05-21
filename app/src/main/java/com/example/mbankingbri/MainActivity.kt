package com.example.mbankingbri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mbankingbri.Screen.LoginScreen
import com.example.mbankingbri.Screen.MenuScreen
import com.example.mbankingbri.Screen.PinScreen
import com.example.mbankingbri.Screen.SuccessScreen
import com.example.mbankingbri.ui.theme.MbankingBRITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MbankingBRITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

fun composable(s: String, function: () -> Unit) {
    TODO("Not yet implemented")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("menu") { MenuScreen(navController) }
        composable("pin") { PinScreen(navController) }
        composable("success") { SuccessScreen(navController) }
    }
}
