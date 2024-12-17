package com.veterinaria.demo.service.impl;

import com.veterinaria.demo.dao.InventarioDao;
import com.veterinaria.demo.domain.Inventario;
import com.veterinaria.demo.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioDao inventarioDao;  // Reemplazamos con InventarioDao

    @Override
    public Inventario crearInventario(Inventario inventario) {
        // Si es necesario, puedes realizar alguna validación o procesamiento adicional aquí
        return inventarioDao.save(inventario); // Guardamos el Inventario en el Dao
    }

    @Override
    public List<Inventario> obtenerTodosLosInventarios() {
        return inventarioDao.findAll(); 
    }

    @Override
    public Optional<Inventario> obtenerInventarioPorId(String id) {
        return inventarioDao.findById(id); // Buscamos Inventario por ID
    }

    @Override
    public Inventario actualizarInventario(String id, Inventario inventario) {
        if (inventarioDao.existsById(id)) { // Verificamos si el Inventario existe antes de actualizarla
            inventario.setId(id); // Establecemos el ID del Inventario antes de actualizar
            return inventarioDao.save(inventario); // Actualizamos el Inventario
        }
        return null; // Si el Inventario no existe, retornamos null o lanzamos una excepción
    }

    @Override
    public void eliminarInventario(String id) {
        inventarioDao.deleteById(id); // Eliminamos el Inventario por ID
    }
}