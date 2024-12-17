package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Doctor;
import java.util.List;
import java.util.Optional;

public interface DoctorService {
    Doctor crearDoctor(Doctor doctor); // Crear un nuevo doctor
    List<Doctor> obtenerTodosLosDoctores(); // Obtener todos los doctores
    Optional<Doctor> obtenerDoctorPorId(String id); // Obtener doctor por su ID
    Doctor actualizarDoctor(String id, Doctor doctor); // Actualizar un doctor
    void eliminarDoctor(String id); // Eliminar un doctor
}
