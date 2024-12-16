package com.veterinaria.demo.service.impl;

import com.veterinaria.demo.dao.EnfermedadDao;
import com.veterinaria.demo.domain.Enfermedad;
import com.veterinaria.demo.service.EnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnfermedadServiceImpl implements EnfermedadService {

    @Autowired
    private EnfermedadDao enfermedadDao;  // Reemplazamos con EnfermedadDao

    @Override
    public Enfermedad crearEnfermedad(Enfermedad enfermedad) {
        // Si es necesario, puedes realizar alguna validación o procesamiento adicional aquí
        return enfermedadDao.save(enfermedad); // Guardamos la Enfermedad en el Dao
    }

    @Override
    public List<Enfermedad> obtenerTodasLasEnfermedades() {
        return enfermedadDao.findAll(); // Obtenemos todas las Enfermedades de la base de datos
    }

    @Override
    public Optional<Enfermedad> obtenerEnfermedadPorId(String id) {
        return enfermedadDao.findById(id); // Buscamos Enfermedad por ID
    }

    @Override
    public Enfermedad actualizarEnfermedad(String id, Enfermedad enfermedad) {
        if (enfermedadDao.existsById(id)) { // Verificamos si la Enfermedad existe antes de actualizarla
            enfermedad.setId(id); // Establecemos el ID de la Enfermedad antes de actualizar
            return enfermedadDao.save(enfermedad); // Actualizamos la Enfermedad
        }
        return null; // Si la Enfermedad no existe, retornamos null o lanzamos una excepción
    }

    @Override
    public void eliminarEnfermedad(String id) {
        enfermedadDao.deleteById(id); // Eliminamos la Enfermedad por ID
    }
}