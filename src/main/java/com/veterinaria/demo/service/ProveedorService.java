
package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Proveedor;
import java.util.List;

public interface ProveedorService {
    List<Proveedor> findAll();
    Proveedor save(Proveedor proveedor);
    void deleteById(String id);
}