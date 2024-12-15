package com.veterinaria.demo.service.impl;

import com.veterinaria.demo.dao.PagoDao;
import com.veterinaria.demo.domain.Pago;
import com.veterinaria.demo.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImpl implements PagoService {
    @Autowired
    private PagoDao repository;

    @Override
    public List<Pago> findAll() {
        return repository.findAll();
    }

    @Override
    public Pago save(Pago pago) {
        return repository.save(pago);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}