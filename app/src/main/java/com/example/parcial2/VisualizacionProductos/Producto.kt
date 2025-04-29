package com.example.parcial2.VisualizacionProductos
import androidx.compose.runtime.mutableStateListOf

data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val descripcion: String,
    val imagenUrl: String
)

object ProductoRepository {
    val productos = mutableStateListOf<Producto>()
    val carrito = mutableStateListOf<Producto>()

    fun agregarProducto(producto: Producto) {
        productos.add(producto)
    }

    fun agregarAlCarrito(producto: Producto) {
        carrito.add(producto)
    }

    fun totalCarrito(): Double = carrito.sumOf { it.precio }
}
