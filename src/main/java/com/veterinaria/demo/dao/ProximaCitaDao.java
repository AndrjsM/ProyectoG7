package com.veterinaria.demo.dao;

import com.veterinaria.demo.domain.ProximaCita;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProximaCitaDao extends MongoRepository<ProximaCita, String> {
    
}