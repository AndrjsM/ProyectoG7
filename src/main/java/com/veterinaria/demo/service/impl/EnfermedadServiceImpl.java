package com.veterinaria.demo.service.impl;

import com.veterinaria.demo.dao.EnfermedadDao;
import com.veterinaria.demo.domain.Enfermedad;
import com.veterinaria.demo.service.EnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnfermedadServiceImpl implements EnfermedadService {
    @Autowired
    private EnfermedadDao repository;

    @Override
    public List<Enfermedad> findAll() {
        return repository.findAll();
    }

    @Override
    public Enfermedad save(Enfermedad enfermedad) {
        return repository.save(enfermedad);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}