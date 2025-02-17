
//Configura la navegación como parte del contenido principal.

package es.iesjm.dam.mvvm_cientificas
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import es.iesjm.dam.mvvm_cientificas.navigation.AppNavigation

import es.iesjm.dam.mvvm_cientificas.ui.theme.MVVM_CientificasTheme


/***
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import es.iesjm.dam.mvvm_cientificas.ui.theme.MVVM_CientificasTheme

***/


// Esta es la actividad principal de la aplicación, que extiende `ComponentActivity`.
// En el método `onCreate`, se configura el contenido de la actividad usando Jetpack Compose,
//  aplicando el tema `MVVM_CientificasTheme`.
// Se inicializa un controlador de navegación (`navController`) y se pasa a la función `AppNavigation`
// para gestionar la navegación entre pantallas.


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVM_CientificasTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}

/***

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVM_CientificasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
 */

