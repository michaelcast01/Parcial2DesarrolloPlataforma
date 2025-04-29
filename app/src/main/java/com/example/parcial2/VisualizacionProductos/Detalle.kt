package com.example.parcial2.VisualizacionProductos

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.parcial2.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error


@Composable
fun DetalleScreen(navController: NavController, productoId: Int) {
    val producto = ProductoRepository.productos.find { it.id == productoId }

    if (producto == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Error,
                contentDescription = "Error",
                tint = MaterialTheme.colorScheme.error,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Producto no encontrado", style = MaterialTheme.typography.headlineSmall)
            Text("El ID solicitado no existe.", color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text("Volver al catálogo")
            }
        }
        return
    }


    Column(modifier = Modifier.padding(16.dp)) {
        AsyncImage(
            model = producto.imagenUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            placeholder = painterResource(R.drawable.placeholder),
            error = painterResource(R.drawable.image_error)
        )
        Text(producto.nombre, style = MaterialTheme.typography.titleLarge)
        Text("Precio: $${producto.precio}")
        Text(producto.descripcion)

        Row {
            Button(onClick = {
                ProductoRepository.agregarAlCarrito(producto)
                navController.popBackStack()
            }) {
                Text("Agregar al Carrito")
            }
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedButton(onClick = { navController.popBackStack() }) {
                Text("Volver")
            }
        }
    }
}
