package com.veterinaria.demo.service;

import com.veterinaria.demo.domain.Pago;
import java.util.List;
import java.util.Optional;

public interface PagoService {
    Pago crearPago(Pago pago); // Crear un nuevo Pago
    List<Pago> obtenerTodosLosPagos(); // Obtener todos los pagos
    Optional<Pago> obtenerPagoPorId(String id); // Obtener Pago por su ID
    Pago actualizarPago(String id, Pago pago); // Actualizar un Pago
    void eliminarPago(String id); // Eliminar un Pago
}