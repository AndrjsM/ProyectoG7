package com.veterinaria.demo.dao;

import com.veterinaria.demo.domain.Tratamiento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TratamientoDao extends MongoRepository<Tratamiento, String> {
}
