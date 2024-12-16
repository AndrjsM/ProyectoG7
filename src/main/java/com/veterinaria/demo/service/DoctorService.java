package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Doctor;
import java.util.List;
import java.util.Optional;

public interface DoctorService {
    Doctor crearDoctor(Doctor doctor);
    List<Doctor> obtenerTodosLosDoctores();
    Optional<Doctor> obtenerDoctorPorId(String id);
    Doctor actualizarDoctor(String id, Doctor doctor);
    void eliminarDoctor(String id);
}
