package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Paciente;
import java.util.List;
import java.util.Optional;

public interface PacienteService {
    Paciente crearPaciente(Paciente paciente); // Crear un nuevo paciente
    List<Paciente> obtenerTodosLosPacientes(); // Obtener todos los pacientes
    Optional<Paciente> obtenerPacientePorId(String id); // Obtener paciente por su ID
    Paciente actualizarPaciente(String id, Paciente paciente); // Actualizar un paciente
    void eliminarPaciente(String id); // Eliminar un paciente
}
