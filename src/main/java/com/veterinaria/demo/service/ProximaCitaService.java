package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.ProximaCita;
import java.util.List;
import java.util.Optional;

public interface ProximaCitaService {
    ProximaCita crearProximaCita(ProximaCita proximaCita); // Crear una nueva ProximaCita
    List<ProximaCita> obtenerTodasLasProximaCitas(); // Obtener todas las ProximaCita
    Optional<ProximaCita> obtenerProximaCitaPorId(String id); // Obtener ProximaCita por su ID
    ProximaCita actualizarProximaCita(String id, ProximaCita proximaCita); // Actualizar una ProximaCita
    void eliminarProximaCita(String id); // Eliminar una ProximaCita
}
