
package com.veterinaria.demo.dao;

import com.veterinaria.demo.domain.Proveedor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProveedorDao extends MongoRepository<Proveedor, String> {
    
}