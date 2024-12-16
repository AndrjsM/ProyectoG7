package com.veterinaria.demo.service.impl;

import com.veterinaria.demo.dao.PagoDao;
import com.veterinaria.demo.domain.Pago;
import com.veterinaria.demo.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoDao pagoDao;  // Reemplazamos con PagoDao

    @Override
    public Pago crearPago(Pago pago) {
        // Si es necesario, puedes realizar alguna validación o procesamiento adicional aquí
        return pagoDao.save(pago); // Guardamos el Pago en el Dao
    }

    @Override
    public List<Pago> obtenerTodosLosPagos() {
        return pagoDao.findAll(); // Obtenemos todas los Pagos de la base de datos
    }

    @Override
    public Optional<Pago> obtenerPagoPorId(String id) {
        return pagoDao.findById(id); // Buscamos Pago por ID
    }

    @Override
    public Pago actualizarPago(String id, Pago pago) {
        if (pagoDao.existsById(id)) { // Verificamos si el Pago existe antes de actualizarla
            pago.setId(id); // Establecemos el ID del Pago antes de actualizar
            return pagoDao.save(pago); // Actualizamos el Pago
        }
        return null; // Si el Pago no existe, retornamos null o lanzamos una excepción
    }

    @Override
    public void eliminarPago(String id) {
        pagoDao.deleteById(id); // Eliminamos el Pago por ID
    }
}