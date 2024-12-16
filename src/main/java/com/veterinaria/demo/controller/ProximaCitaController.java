package com.veterinaria.demo.controller;

import com.veterinaria.demo.domain.ProximaCita;
import com.veterinaria.demo.service.ProximaCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/proximaCitas")
public class ProximaCitaController {

    @Autowired
    private ProximaCitaService proximaCitaService;

    // Listar todas las enfermedades
    @GetMapping
    public String listarProximaCitas(Model model) {
        List<ProximaCita> proximaCitas = proximaCitaService.obtenerTodasLasProximaCitas();
        model.addAttribute("proximaCitas", proximaCitas);
        return "proximaCitas/proximaCitas"; // Nombre del template para la lista
    }

    // Mostrar el formulario para agregar una nueva ProximaCita
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaProximaCita(Model model) {
        model.addAttribute("proximaCita", new ProximaCita()); // Pasamos un objeto vacío para el formulario
        return "proximaCitas/nuevaProximaCita"; // Template para crear una nueva ProximaCita
    }

    // Crear una nueva ProximaCita
    @PostMapping("/crear")
    public String crearProximaCita(@ModelAttribute ProximaCita proximaCita) {
        proximaCitaService.crearProximaCita(proximaCita);
        return "redirect:/proximaCitas"; // Redirigir a la lista de ProximaCitas después de crear
    }

    // Mostrar el formulario para editar una ProximaCita
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Optional<ProximaCita> proximaCita = proximaCitaService.obtenerProximaCitaPorId(id);
        if (proximaCita.isPresent()) {
            model.addAttribute("proximaCita", proximaCita.get());
            return "proximaCitas/editarProximaCita"; // Template con el formulario de edición
        } else {
            return "redirect:/proximaCitas"; // Redirigir a la lista de proximaCitas si no se encuentra la proximaCita
        }
    }

    // Editar una ProximaCita
    @PostMapping("/editar/{id}")
    public String editarProximaCita(@PathVariable String id, @ModelAttribute ProximaCita proximaCita) {
        proximaCitaService.actualizarProximaCita(id, proximaCita);
        return "redirect:/proximaCitas"; // Redirigir a la lista de ProximaCitas después de editar
    }

    // Eliminar una medicina
    @PostMapping("/eliminar/{id}")
    public String eliminarProximaCita(@PathVariable String id) {
        proximaCitaService.eliminarProximaCita(id);
        return "redirect:/proximaCitas"; // Redirigir a la lista de ProximaCitas después de eliminar
    }
}
