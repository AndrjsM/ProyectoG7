package com.veterinaria.demo.controller;

import com.mongodb.MongoWriteException;
import com.veterinaria.demo.domain.Doctor;
import com.veterinaria.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/doctores")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Listar todos los doctores
    @GetMapping
    public String listarDoctores(Model model) {
        List<Doctor> doctores = doctorService.obtenerTodosLosDoctores();
        model.addAttribute("doctores", doctores);
        return "doctores/doctores"; // Nombre del template para la lista
    }

    // Mostrar el formulario para agregar un nuevo doctor
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoDoctor(Model model) {
        model.addAttribute("doctor", new Doctor()); // Pasamos un objeto vacío para el formulario
        return "doctores/nuevoDoctor"; // Template para crear un nuevo doctor
    }

    // Crear un nuevo doctor con manejo de errores
    @PostMapping("/crear")
    public String crearDoctor(@ModelAttribute Doctor doctor, Model model) {
        try {
            doctorService.crearDoctor(doctor);
            return "redirect:/doctores"; // Redirigir a la lista de doctores después de crear
        } catch (MongoWriteException e) {
            model.addAttribute("error", "Error al crear el doctor: " + e.getMessage());
            model.addAttribute("doctor", doctor); // Mantener los datos del formulario
            return "doctores/nuevoDoctor"; // Volver al formulario con el mensaje de error
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error inesperado: " + e.getMessage());
            model.addAttribute("doctor", doctor);
            return "doctores/nuevoDoctor";
        }
    }

    // Mostrar el formulario para editar un doctor
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Optional<Doctor> doctor = doctorService.obtenerDoctorPorId(id);
        if (doctor.isPresent()) {
            model.addAttribute("doctor", doctor.get());
            return "doctores/editarDoctor"; // Template con el formulario de edición
        } else {
            return "redirect:/doctores"; // Redirigir a la lista de doctores si no se encuentra el doctor
        }
    }

    // Editar un doctor con manejo de errores
    @PostMapping("/editar/{id}")
    public String editarDoctor(@PathVariable String id, @ModelAttribute Doctor doctor, Model model) {
        try {
            doctorService.actualizarDoctor(id, doctor);
            return "redirect:/doctores"; // Redirigir a la lista de doctores después de editar
        } catch (MongoWriteException e) {
            model.addAttribute("error", "Error al actualizar el doctor: " + e.getMessage());
            model.addAttribute("doctor", doctor); // Mantener los datos del formulario
            return "doctores/editarDoctor"; // Volver al formulario con el mensaje de error
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error inesperado: " + e.getMessage());
            model.addAttribute("doctor", doctor);
            return "doctores/editarDoctor";
        }
    }

    // Eliminar un doctor
    @PostMapping("/eliminar/{id}")
    public String eliminarDoctor(@PathVariable String id) {
        doctorService.eliminarDoctor(id);
        return "redirect:/doctores"; // Redirigir a la lista de doctores después de eliminar
    }
}
