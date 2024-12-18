package com.veterinaria.demo.dao;

import com.veterinaria.demo.domain.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends MongoRepository<Usuario, String> {
    
}