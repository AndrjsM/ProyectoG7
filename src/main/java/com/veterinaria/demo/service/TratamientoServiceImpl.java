package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Tratamiento;
import com.veterinaria.demo.dao.TratamientoDao; // Asegúrate de crear un TratamientoDao
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    private TratamientoDao tratamientoDao;  // Reemplazamos con tratamientoDao

    @Override
    public Tratamiento crearTratamiento(Tratamiento tratamiento) {
        // Si es necesario, puedes realizar alguna validación o procesamiento adicional aquí
        return tratamientoDao.save(tratamiento); // Guardamos el tratamiento en el Dao
    }

    @Override
    public List<Tratamiento> obtenerTodosLosTratamientos() {
        return tratamientoDao.findAll(); // Obtenemos todos los tratamientos de la base de datos
    }

    @Override
    public Optional<Tratamiento> obtenerTratamientoPorId(String id) {
        return tratamientoDao.findById(id); // Buscamos tratamiento por ID
    }

    @Override
    public Tratamiento actualizarTratamiento(String id, Tratamiento tratamiento) {
        if (tratamientoDao.existsById(id)) { // Verificamos si el tratamiento existe antes de actualizarlo
            tratamiento.setId(id); // Establecemos el ID del tratamiento antes de actualizar
            return tratamientoDao.save(tratamiento); // Actualizamos el tratamiento
        }
        return null; // Si el tratamiento no existe, retornamos null o lanzamos una excepción
    }

    @Override
    public void eliminarTratamiento(String id) {
        tratamientoDao.deleteById(id); // Eliminamos el tratamiento por ID
    }
}

