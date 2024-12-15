package com.veterinaria.demo.dao;

import com.veterinaria.demo.domain.Pago;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PagoDao extends MongoRepository<Pago, String> {
    
}