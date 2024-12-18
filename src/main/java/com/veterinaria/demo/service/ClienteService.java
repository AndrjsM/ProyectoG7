package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> findAll();
    Cliente findById(String id);
    Cliente save(Cliente cliente);
    void deleteById(String id);
}