package com.veterinaria.demo.controller;

import com.mongodb.MongoWriteException;
import com.veterinaria.demo.domain.Tratamiento;
import com.veterinaria.demo.service.TratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tratamientos")
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

    // Listar todos los tratamientos
    @GetMapping
    public String listarTratamientos(Model model) {
        List<Tratamiento> tratamientos = tratamientoService.obtenerTodosLosTratamientos();
        model.addAttribute("tratamientos", tratamientos);
        return "tratamientos/tratamientos"; // Nombre del template para la lista
    }

    // Mostrar el formulario para agregar un nuevo tratamiento
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoTratamiento(Model model) {
        model.addAttribute("tratamiento", new Tratamiento()); // Pasamos un objeto vacío para el formulario
        return "tratamientos/nuevoTratamiento"; // Template para crear un nuevo tratamiento
    }

    // Crear un nuevo tratamiento con manejo de errores
    @PostMapping("/crear")
    public String crearTratamiento(@ModelAttribute Tratamiento tratamiento, Model model) {
        try {
            tratamientoService.crearTratamiento(tratamiento);
            return "redirect:/tratamientos"; // Redirigir a la lista de tratamientos después de crear
        } catch (MongoWriteException e) {
            model.addAttribute("error", "Error al crear el tratamiento: " + e.getMessage());
            model.addAttribute("tratamiento", tratamiento); // Mantener los datos del formulario
            return "tratamientos/nuevoTratamiento"; // Volver al formulario con el mensaje de error
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error inesperado: " + e.getMessage());
            model.addAttribute("tratamiento", tratamiento);
            return "tratamientos/nuevoTratamiento";
        }
    }

    // Mostrar el formulario para editar un tratamiento
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Optional<Tratamiento> tratamiento = tratamientoService.obtenerTratamientoPorId(id);
        if (tratamiento.isPresent()) {
            model.addAttribute("tratamiento", tratamiento.get());
            return "tratamientos/editarTratamiento"; // Template con el formulario de edición
        } else {
            return "redirect:/tratamientos"; // Redirigir a la lista de tratamientos si no se encuentra el tratamiento
        }
    }

    // Editar un tratamiento con manejo de errores
    @PostMapping("/editar/{id}")
    public String editarTratamiento(@PathVariable String id, @ModelAttribute Tratamiento tratamiento, Model model) {
        try {
            tratamientoService.actualizarTratamiento(id, tratamiento);
            return "redirect:/tratamientos"; // Redirigir a la lista de tratamientos después de editar
        } catch (MongoWriteException e) {
            model.addAttribute("error", "Error al actualizar el tratamiento: " + e.getMessage());
            model.addAttribute("tratamiento", tratamiento); // Mantener los datos del formulario
            return "tratamientos/editarTratamiento"; // Volver al formulario con el mensaje de error
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error inesperado: " + e.getMessage());
            model.addAttribute("tratamiento", tratamiento);
            return "tratamientos/editarTratamiento";
        }
    }

    // Eliminar un tratamiento
    @PostMapping("/eliminar/{id}")
    public String eliminarTratamiento(@PathVariable String id) {
        tratamientoService.eliminarTratamiento(id);
        return "redirect:/tratamientos"; // Redirigir a la lista de tratamientos después de eliminar
    }
}

