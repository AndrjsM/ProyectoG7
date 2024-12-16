package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Producto crearProducto(Producto producto); // Crear un nuevo Producto
    List<Producto> obtenerTodosLosProductos(); // Obtener todos los Producto
    Optional<Producto> obtenerProductoPorId(String id); // Obtener Producto por su ID
    Producto actualizarProducto(String id, Producto producto); // Actualizar un Producto
    void eliminarProducto(String id); // Eliminar un Producto
}