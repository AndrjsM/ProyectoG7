package com.veterinaria.demo.service.impl;

import com.veterinaria.demo.dao.ClienteDao;
import com.veterinaria.demo.domain.Cliente;
import com.veterinaria.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Override
    public Cliente findById(String id) {
        Optional<Cliente> cliente = clienteDao.findById(id);
        return cliente.orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public void deleteById(String id) {
        clienteDao.deleteById(id);
    }
}