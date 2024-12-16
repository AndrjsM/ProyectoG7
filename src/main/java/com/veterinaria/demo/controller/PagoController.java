package com.veterinaria.demo.controller;

import com.veterinaria.demo.domain.Pago;
import com.veterinaria.demo.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    // Listar todas las Pagos
    @GetMapping
    public String listarPagos(Model model) {
        List<Pago> pagos = pagoService.obtenerTodosLosPagos();
        model.addAttribute("pagos", pagos);
        return "pagos/pagos"; // Nombre del template para la lista
    }

    // Mostrar el formulario para agregar un nuevo pago
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoPago(Model model) {
        model.addAttribute("pago", new Pago()); // Pasamos un objeto vacío para el formulario
        return "pagos/nuevoPago"; // Template para crear un nuevo pago
    }

    // Crear una nueva enfermedad
    @PostMapping("/crear")
    public String crearPago(@ModelAttribute Pago pago) {
        pagoService.crearPago(pago);
        return "redirect:/pagos"; // Redirigir a la lista de Pagos después de crear
    }

    // Mostrar el formulario para editar un Pago
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Optional<Pago> pago = pagoService.obtenerPagoPorId(id);
        if (pago.isPresent()) {
            model.addAttribute("pago", pago.get());
            return "pagos/editarPago"; // Template con el formulario de edición
        } else {
            return "redirect:/pagos"; // Redirigir a la lista de pagos si no se encuentra el pago
        }
    }

    // Editar un pago
    @PostMapping("/editar/{id}")
    public String editarPago(@PathVariable String id, @ModelAttribute Pago pago) {
        pagoService.actualizarPago(id, pago);
        return "redirect:/pagos"; // Redirigir a la lista de Pagos después de editar
    }

    // Eliminar una medicina
    @PostMapping("/eliminar/{id}")
    public String eliminarPago(@PathVariable String id) {
        pagoService.eliminarPago(id);
        return "redirect:/pagos"; // Redirigir a la lista de pagos después de eliminar
    }
}