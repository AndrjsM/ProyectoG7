package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Pago;
import java.util.List;

public interface PagoService {
    List<Pago> findAll();
    Pago save(Pago pago);
    void deleteById(String id);
}