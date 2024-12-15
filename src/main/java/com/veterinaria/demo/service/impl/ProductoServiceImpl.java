package com.veterinaria.demo.service.impl;

import com.veterinaria.demo.dao.ProductoDao;
import com.veterinaria.demo.domain.Producto;
import com.veterinaria.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoDao repository;

    @Override
    public List<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}