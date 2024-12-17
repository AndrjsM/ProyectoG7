package com.veterinaria.demo.dao;

import com.veterinaria.demo.domain.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorDao extends MongoRepository<Doctor, String> {
}
