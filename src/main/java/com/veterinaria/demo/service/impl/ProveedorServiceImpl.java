package com.veterinaria.demo.service.impl;

import com.veterinaria.demo.dao.ProveedorDao;
import com.veterinaria.demo.domain.Proveedor;
import com.veterinaria.demo.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {
    @Autowired
    private ProveedorDao repository;

    @Override
    public List<Proveedor> findAll() {
        return repository.findAll();
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}