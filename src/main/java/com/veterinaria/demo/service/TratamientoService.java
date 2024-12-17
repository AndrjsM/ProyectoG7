package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Tratamiento;
import java.util.List;
import java.util.Optional;

public interface TratamientoService {
    Tratamiento crearTratamiento(Tratamiento tratamiento); // Crear un nuevo tratamiento
    List<Tratamiento> obtenerTodosLosTratamientos(); // Obtener todos los tratamientos
    Optional<Tratamiento> obtenerTratamientoPorId(String id); // Obtener un tratamiento por su ID
    Tratamiento actualizarTratamiento(String id, Tratamiento tratamiento); // Actualizar un tratamiento
    void eliminarTratamiento(String id); // Eliminar un tratamiento
}
