package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Enfermedad;
import java.util.List;
import java.util.Optional;

public interface EnfermedadService {
    Enfermedad crearEnfermedad(Enfermedad enfermedad); // Crear una nueva Enfermedad
    List<Enfermedad> obtenerTodasLasEnfermedades(); // Obtener todas las Enfermedad
    Optional<Enfermedad> obtenerEnfermedadPorId(String id); // Obtener Enfermedad por su ID
    Enfermedad actualizarEnfermedad(String id, Enfermedad enfermedad); // Actualizar una Enfermedad
    void eliminarEnfermedad(String id); // Eliminar una Enfermedad
}
