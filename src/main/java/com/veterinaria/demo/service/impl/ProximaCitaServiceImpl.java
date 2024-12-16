package com.veterinaria.demo.service.impl;

import com.veterinaria.demo.dao.ProximaCitaDao;
import com.veterinaria.demo.domain.ProximaCita;
import com.veterinaria.demo.service.ProximaCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProximaCitaServiceImpl implements ProximaCitaService {

    @Autowired
    private ProximaCitaDao proximaCitaDao;  // Reemplazamos con ProximaCitaDao

    @Override
    public ProximaCita crearProximaCita(ProximaCita proximaCita) {
        // Si es necesario, puedes realizar alguna validación o procesamiento adicional aquí
        return proximaCitaDao.save(proximaCita); // Guardamos la ProximaCita en el Dao
    }

    @Override
    public List<ProximaCita> obtenerTodasLasProximaCitas() {
        return proximaCitaDao.findAll(); // Obtenemos todas las ProximaCitas de la base de datos
    }

    @Override
    public Optional<ProximaCita> obtenerProximaCitaPorId(String id) {
        return proximaCitaDao.findById(id); // Buscamos ProximaCita por ID
    }

    @Override
    public ProximaCita actualizarProximaCita(String id, ProximaCita proximaCita) {
        if (proximaCitaDao.existsById(id)) { // Verificamos si la ProximaCita existe antes de actualizarla
            proximaCita.setId(id); // Establecemos el ID de la ProximaCita antes de actualizar
            return proximaCitaDao.save(proximaCita); // Actualizamos la ProximaCita
        }
        return null; // Si la ProximaCita no existe, retornamos null o lanzamos una excepción
    }

    @Override
    public void eliminarProximaCita(String id) {
        proximaCitaDao.deleteById(id); // Eliminamos la ProximaCita por ID
    }
}