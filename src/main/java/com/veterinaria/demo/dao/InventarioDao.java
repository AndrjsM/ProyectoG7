package com.veterinaria.demo.dao;

import com.veterinaria.demo.domain.Inventario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioDao extends MongoRepository<Inventario, String> {
}