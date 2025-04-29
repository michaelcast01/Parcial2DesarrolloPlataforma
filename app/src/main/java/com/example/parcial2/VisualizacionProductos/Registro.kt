package com.example.parcial2.VisualizacionProductos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.Composable


@Composable
fun RegistroScreen(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var imagenUrl by remember { mutableStateOf("") }

    var nombreError by remember { mutableStateOf(false) }
    var precioError by remember { mutableStateOf(false) }
    var descripcionError by remember { mutableStateOf(false) }
    var imagenUrlError by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("Agregar Producto", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = nombre,
            onValueChange = {
                nombre = it
                nombreError = false
            },
            label = { Text("Nombre") },
            isError = nombreError,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = precio,
            onValueChange = {
                precio = it
                precioError = false
            },
            label = { Text("Precio") },
            isError = precioError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = descripcion,
            onValueChange = {
                descripcion = it
                descripcionError = false
            },
            label = { Text("Descripción") },
            isError = descripcionError,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = imagenUrl,
            onValueChange = {
                imagenUrl = it
                imagenUrlError = false
            },
            label = { Text("URL de Imagen") },
            isError = imagenUrlError,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = {
                // Validación de campos
                nombreError = nombre.isBlank()
                precioError = precio.isBlank()
                descripcionError = descripcion.isBlank()
                imagenUrlError = imagenUrl.isBlank()

                val camposValidos = !nombreError && !precioError && !descripcionError && !imagenUrlError

                if (camposValidos) {
                    val producto = Producto(
                        id = ProductoRepository.productos.size + 1,
                        nombre = nombre,
                        precio = precio.toDoubleOrNull() ?: 0.0,
                        descripcion = descripcion,
                        imagenUrl = imagenUrl
                    )
                    ProductoRepository.agregarProducto(producto)
                    navController.popBackStack()
                }
            }) {
                Text("Guardar")
            }

            OutlinedButton(onClick = {
                navController.popBackStack()
            }) {
                Text("Cancelar")
            }
        }
    }
}
