package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Enfermedad;
import java.util.List;

public interface EnfermedadService {
    List<Enfermedad> findAll();
    Enfermedad save(Enfermedad enfermedad);
    void deleteById(String id);
}