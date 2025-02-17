package es.iesjm.dam.mvvm_cientificas.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import es.iesjm.dam.mvvm_cientificas.ui.theme.MVVM_CientificasTheme
import kotlinx.coroutines.delay


//Pantalla de inicio que lleva a la lista de mujeres cientificas

@Composable
fun HomeScreen(navController: NavController) {
    var loading by remember { mutableStateOf(false) }

    // Maneja el efecto de carga cuando se activa `loading`
    LaunchedEffect(loading) {
        if (loading) {
            delay(2000) // Simula la carga durante 2 segundos
            loading = false
            navController.navigate("lista")
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (loading) {
                CircularProgressIndicator(modifier = Modifier.size(50.dp))
            } else {
                Text(
                    text = "Mujeres Científicas",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                ElevatedButton(
                    onClick = {
                        loading = true
                    },
                    colors = ButtonDefaults.elevatedButtonColors(MaterialTheme.colorScheme.primary)
                ) {
                    Text("Descubre", color = MaterialTheme.colorScheme.onPrimary)
                }
            }
        }
    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    MVVM_CientificasTheme {
        HomeScreen(rememberNavController())
    }
}
