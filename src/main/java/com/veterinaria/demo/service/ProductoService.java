package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> findAll();
    Producto save(Producto producto);
    void deleteById(String id);
}