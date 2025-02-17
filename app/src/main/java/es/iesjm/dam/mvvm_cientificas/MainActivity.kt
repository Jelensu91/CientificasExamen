package es.iesjm.dam.mvvm_cientificas
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import es.iesjm.dam.mvvm_cientificas.navigation.AppNavigation
import es.iesjm.dam.mvvm_cientificas.ui.theme.MVVM_CientificasTheme

// Esta es la actividad principal de la aplicación, se pasa a la función `AppNavigation`
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


