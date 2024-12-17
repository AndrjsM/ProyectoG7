package com.veterinaria.demo.controller;

import com.mongodb.MongoWriteException;
import com.veterinaria.demo.domain.Paciente;
import com.veterinaria.demo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Listar todos los pacientes
    @GetMapping
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.obtenerTodosLosPacientes();
        model.addAttribute("pacientes", pacientes);
        return "pacientes/pacientes"; // Nombre del template para la lista
    }

    // Mostrar el formulario para agregar un nuevo paciente
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoPaciente(Model model) {
        model.addAttribute("paciente", new Paciente()); // Pasamos un objeto vacío para el formulario
        return "pacientes/nuevoPaciente"; // Template para crear un nuevo paciente
    }

    // Crear un nuevo paciente con manejo de errores
    @PostMapping("/crear")
    public String crearPaciente(@ModelAttribute Paciente paciente, Model model) {
        try {
            pacienteService.crearPaciente(paciente);
            return "redirect:/pacientes"; // Redirigir a la lista de pacientes después de crear
        } catch (MongoWriteException e) {
            model.addAttribute("error", "Error al crear el paciente: " + e.getMessage());
            model.addAttribute("paciente", paciente); // Mantener los datos del formulario
            return "pacientes/nuevoPaciente"; // Volver al formulario con el mensaje de error
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error inesperado: " + e.getMessage());
            model.addAttribute("paciente", paciente);
            return "pacientes/nuevoPaciente";
        }
    }

    // Mostrar el formulario para editar un paciente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Optional<Paciente> paciente = pacienteService.obtenerPacientePorId(id);
        if (paciente.isPresent()) {
            model.addAttribute("paciente", paciente.get());
            return "pacientes/editarPaciente"; // Template con el formulario de edición
        } else {
            return "redirect:/pacientes"; // Redirigir a la lista de pacientes si no se encuentra el paciente
        }
    }

    // Editar un paciente con manejo de errores
    @PostMapping("/editar/{id}")
    public String editarPaciente(@PathVariable String id, @ModelAttribute Paciente paciente, Model model) {
        try {
            pacienteService.actualizarPaciente(id, paciente);
            return "redirect:/pacientes"; // Redirigir a la lista de pacientes después de editar
        } catch (MongoWriteException e) {
            model.addAttribute("error", "Error al actualizar el paciente: " + e.getMessage());
            model.addAttribute("paciente", paciente); // Mantener los datos del formulario
            return "pacientes/editarPaciente"; // Volver al formulario con el mensaje de error
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error inesperado: " + e.getMessage());
            model.addAttribute("paciente", paciente);
            return "pacientes/editarPaciente";
        }
    }

    // Eliminar un paciente
    @PostMapping("/eliminar/{id}")
    public String eliminarPaciente(@PathVariable String id) {
        pacienteService.eliminarPaciente(id);
        return "redirect:/pacientes"; // Redirigir a la lista de pacientes después de eliminar
    }
}
