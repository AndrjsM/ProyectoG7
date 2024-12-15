package com.veterinaria.demo.dao;

import com.veterinaria.demo.domain.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoDao extends MongoRepository<Producto, String> {
    
}