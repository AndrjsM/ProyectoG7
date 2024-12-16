package com.veterinaria.demo.controller;

import com.veterinaria.demo.domain.Enfermedad;
import com.veterinaria.demo.service.EnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/enfermedades")
public class EnfermedadController {

    @Autowired
    private EnfermedadService enfermedadService;

    // Listar todas las enfermedades
    @GetMapping
    public String listarEnfermedades(Model model) {
        List<Enfermedad> enfermedades = enfermedadService.obtenerTodasLasEnfermedades();
        model.addAttribute("enfermedades", enfermedades);
        return "enfermedades/enfermedades"; // Nombre del template para la lista
    }

    // Mostrar el formulario para agregar una nueva enfermedad
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaEnfermedad(Model model) {
        model.addAttribute("enfermedad", new Enfermedad()); // Pasamos un objeto vacío para el formulario
        return "enfermedades/nuevaEnfermedad"; // Template para crear una nueva enfermedad
    }

    // Crear una nueva enfermedad
    @PostMapping("/crear")
    public String crearEnfermedad(@ModelAttribute Enfermedad enfermedad) {
        enfermedadService.crearEnfermedad(enfermedad);
        return "redirect:/enfermedades"; // Redirigir a la lista de Enfermedades después de crear
    }

    // Mostrar el formulario para editar una Enfermedad
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Optional<Enfermedad> enfermedad = enfermedadService.obtenerEnfermedadPorId(id);
        if (enfermedad.isPresent()) {
            model.addAttribute("enfermedad", enfermedad.get());
            return "enfermedades/editarEnfermedad"; // Template con el formulario de edición
        } else {
            return "redirect:/enfermedades"; // Redirigir a la lista de enfermedades si no se encuentra la medicina
        }
    }

    // Editar una enfermedad
    @PostMapping("/editar/{id}")
    public String editarEnfermedad(@PathVariable String id, @ModelAttribute Enfermedad enfermedad) {
        enfermedadService.actualizarEnfermedad(id, enfermedad);
        return "redirect:/enfermedades"; // Redirigir a la lista de Enfermedades después de editar
    }

    // Eliminar una medicina
    @PostMapping("/eliminar/{id}")
    public String eliminarEnfermedad(@PathVariable String id) {
        enfermedadService.eliminarEnfermedad(id);
        return "redirect:/enfermedades"; // Redirigir a la lista de Enfermedades después de eliminar
    }
}