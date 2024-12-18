package com.veterinaria.demo.dao;

import com.veterinaria.demo.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDao extends MongoRepository<Cliente, String> {
}