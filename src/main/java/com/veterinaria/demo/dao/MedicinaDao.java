package com.veterinaria.demo.dao;

import com.veterinaria.demo.domain.Medicina;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicinaDao extends MongoRepository<Medicina, String> {
}
