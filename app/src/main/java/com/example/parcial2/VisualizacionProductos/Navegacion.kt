package com.example.parcial2.VisualizacionProductos


sealed class Pantalla(val ruta: String) {
    object Catalogo : Pantalla("catalogo")
    object Detalle : Pantalla("detalle/{productoId}") {
        fun crearRutaConId(id: Int) = "detalle/$id"
    }
    object Registro : Pantalla("registro")
    object Carrito : Pantalla("carrito")
}
