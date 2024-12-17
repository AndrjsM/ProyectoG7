package com.veterinaria.demo.dao;

import com.veterinaria.demo.domain.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PacienteDao extends MongoRepository<Paciente, String> {
}
