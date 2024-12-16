package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Medicina;
import java.util.List;
import java.util.Optional;

public interface MedicinaService {
    Medicina crearMedicina(Medicina medicina); // Crear una nueva medicina
    List<Medicina> obtenerTodasLasMedicinas(); // Obtener todas las medicinas
    Optional<Medicina> obtenerMedicinaPorId(String id); // Obtener medicina por su ID
    Medicina actualizarMedicina(String id, Medicina medicina); // Actualizar una medicina
    void eliminarMedicina(String id); // Eliminar una medicina
}
