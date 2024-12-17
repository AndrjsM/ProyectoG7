package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Paciente;
import com.veterinaria.demo.dao.PacienteDao; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteDao pacienteDao;  // Reemplazamos con pacienteDao

    @Override
    public Paciente crearPaciente(Paciente paciente) {
        // Si es necesario, puedes realizar alguna validación o procesamiento adicional aquí
        return pacienteDao.save(paciente); // Guardamos el paciente en el Dao
    }

    @Override
    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteDao.findAll(); // Obtenemos todos los pacientes de la base de datos
    }

    @Override
    public Optional<Paciente> obtenerPacientePorId(String id) {
        return pacienteDao.findById(id); // Buscamos paciente por ID
    }

    @Override
    public Paciente actualizarPaciente(String id, Paciente paciente) {
        if (pacienteDao.existsById(id)) { // Verificamos si el paciente existe antes de actualizarlo
            paciente.setId(id); // Establecemos el ID del paciente antes de actualizar
            return pacienteDao.save(paciente); // Actualizamos el paciente
        }
        return null; // Si el paciente no existe, retornamos null o lanzamos una excepción
    }

    @Override
    public void eliminarPaciente(String id) {
        pacienteDao.deleteById(id); // Eliminamos el paciente por ID
    }
}
