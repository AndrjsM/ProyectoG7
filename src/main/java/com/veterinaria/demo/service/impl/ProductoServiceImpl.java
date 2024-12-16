package com.veterinaria.demo.service.impl;

import com.veterinaria.demo.dao.ProductoDao;
import com.veterinaria.demo.domain.Producto;
import com.veterinaria.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;  // Reemplazamos con ProductoDao

    @Override
    public Producto crearProducto(Producto producto) {
        // Si es necesario, puedes realizar alguna validación o procesamiento adicional aquí
        return productoDao.save(producto); // Guardamos el Producto en el Dao
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoDao.findAll(); // Obtenemos todos los Productos de la base de datos
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(String id) {
        return productoDao.findById(id); // Buscamos Producto por ID
    }

    @Override
    public Producto actualizarProducto(String id, Producto producto) {
        if (productoDao.existsById(id)) { // Verificamos si el Producto existe antes de actualizarla
            producto.setId(id); // Establecemos el ID del Producto antes de actualizar
            return productoDao.save(producto); // Actualizamos el Producto
        }
        return null; // Si el Producto no existe, retornamos null o lanzamos una excepción
    }

    @Override
    public void eliminarProducto(String id) {
        productoDao.deleteById(id); // Eliminamos el Producto por ID
    }
}