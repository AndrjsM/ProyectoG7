package com.veterinaria.demo.dao;

import com.veterinaria.demo.domain.Enfermedad;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnfermedadDao extends MongoRepository<Enfermedad, String> {
    
}