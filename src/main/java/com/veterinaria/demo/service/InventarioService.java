package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Inventario;
import java.util.List;
import java.util.Optional;

public interface InventarioService {
    Inventario crearInventario(Inventario inventario); // Crear un nuevo Inventario
    List<Inventario> obtenerTodosLosInventarios(); // Obtener todos los Inventario
    Optional<Inventario> obtenerInventarioPorId(String id); // Obtener Inventario por su ID
    Inventario actualizarInventario(String id, Inventario inventario); // Actualizar un Inventario
    void eliminarInventario(String id); // Eliminar un Inventario
}