package com.veterinaria.demo.controller;

import com.veterinaria.demo.domain.Inventario;
import com.veterinaria.demo.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/inventarios")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    // Listar todos los Inventarios
    @GetMapping
    public String listarInventarios(Model model) {
        List<Inventario> inventarios = inventarioService.obtenerTodosLosInventarios();
        model.addAttribute("inventarios", inventarios);
        return "inventarios/inventarios"; // Nombre del template para la lista
    }

    // Mostrar el formulario para agregar un nuevo doctor
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoInventario(Model model) {
        model.addAttribute("inventario", new Inventario()); // Pasamos un objeto vacío para el formulario
        return "inventarios/nuevoInventario"; // Template para crear un nuevo Inventario
    }

    // Crear un nuevo doctor
    @PostMapping("/crear")
    public String crearInventario(@ModelAttribute Inventario inventario) {
        inventarioService.crearInventario(inventario);
        return "redirect:/inventarios"; // Redirigir a la lista de Inventario después de crear
    }

    // Mostrar el formulario para editar un doctor
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Optional<Inventario> inventario = inventarioService.obtenerInventarioPorId(id);
        if (inventario.isPresent()) {
            model.addAttribute("inventario", inventario.get());
            return "inventarios/editarInventario"; // Template con el formulario de edición
        } else {
            return "redirect:/inventarios"; // Redirigir a la lista de Inventarios si no se encuentra el Inventario
        }
    }

    // Editar un Inventario
    @PostMapping("/editar/{id}")
    public String editarInventario(@PathVariable String id, @ModelAttribute Inventario inventario) {
        inventarioService.actualizarInventario(id, inventario);
        return "redirect:/inventarios"; // Redirigir a la lista de Inventarios después de editar
    }

@PostMapping("/eliminar/{id}")
public String eliminarInventario(@PathVariable String id) {
    inventarioService.eliminarInventario(id);
    return "redirect:/inventarios"; // Redirigir a la lista de Inventario después de eliminar
}

}