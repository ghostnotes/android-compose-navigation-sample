package co.ghostnotes.sample.compose.navigation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.ghostnotes.sample.compose.navigation.R
import co.ghostnotes.sample.compose.navigation.ui.theme.ComposeNavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationSampleTheme {
                val navController = rememberNavController()
                
                Surface(color = MaterialTheme.colors.background) {
                    NavigationComponent(navController = navController)
                }
            }
        }
    }
}

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "first"
    ) {
        composable("first") {
            FirstScreen(navController)
        }
        composable("second") {
            SecondScreen(navController)
        }
        composable("third") {
            ThirdScreen(navController)
        }
    }
}

@Composable
fun FirstScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.label_first_screen))
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("second") }) {
            Text(text = stringResource(id = R.string.button_next))
        }
    }
}

@Composable
fun SecondScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.label_second_screen))
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("third") }) {
            Text(text = stringResource(id = R.string.button_next))
        }
    }
}

@Composable
fun ThirdScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.label_third_screen))
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.popBackStack("first", false) }) {
            Text(text = stringResource(id = R.string.button_go_back))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    ComposeNavigationSampleTheme {
        val navController = rememberNavController()
        FirstScreen(navController = navController)
    }
}