package es.iesjm.dam.mvvm_cientificas.navigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import es.iesjm.dam.mvvm_cientificas.view.DetalleCientificaScreen
import es.iesjm.dam.mvvm_cientificas.view.HomeScreen
import es.iesjm.dam.mvvm_cientificas.view.ListaCientificasScreen
import es.iesjm.dam.mvvm_cientificas.viewmodel.CientificasViewModel

// Esta función define la navegación de la app
// Se usa un `NavHost` con tres destinos: "home",  "lista" para mostrar las científicas
// y "detalle" para ver los detalles de una científica.
// La información de las científicas se gestionan con el ViewModel
// y se pasan a las pantallas correspondientes.


@Composable
fun AppNavigation(navController: NavHostController) {

    val viewModel: CientificasViewModel = viewModel(factory = CientificasViewModel.factory)
    val cientificas by viewModel.getCientificas().collectAsState(initial = emptyList())


    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                navController = navController
            )
        }
        composable("lista") {
            ListaCientificasScreen(
                navController = navController,
                cientificas = cientificas
            )
        }
        composable("detalle/{nombre}") { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre")
            val cientifica = cientificas.find { it.nombre == nombre }
            cientifica?.let {
                DetalleCientificaScreen(cientifica = it)
            }
        }
    }
}

