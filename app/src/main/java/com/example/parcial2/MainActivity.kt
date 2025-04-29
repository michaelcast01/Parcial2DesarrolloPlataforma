package com.example.parcial2


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.parcial2.VisualizacionProductos.CatalogoScreen
import com.example.parcial2.VisualizacionProductos.DetalleScreen
import com.example.parcial2.VisualizacionProductos.RegistroScreen
import com.example.parcial2.VisualizacionProductos.CarritoScreen
import com.example.parcial2.VisualizacionProductos.Pantalla
import com.example.parcial2.ui.theme.Parcial2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial2Theme {
                AppNavegacion()
            }
        }
    }
}

@Composable
fun AppNavegacion() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Pantalla.Catalogo.ruta) {
        composable(Pantalla.Catalogo.ruta) {
            CatalogoScreen(navController)
        }
        composable(Pantalla.Registro.ruta) {
            RegistroScreen(navController)
        }
        composable(
            Pantalla.Detalle.ruta,
            arguments = listOf(navArgument("productoId") { type = NavType.IntType })
        ) {
            val productoId = it.arguments?.getInt("productoId") ?: -1
            DetalleScreen(navController, productoId)
        }
        composable(Pantalla.Carrito.ruta) {
            CarritoScreen(navController)
        }
    }
}
