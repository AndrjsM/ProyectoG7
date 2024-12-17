package com.veterinaria.demo.controller;

import com.mongodb.MongoWriteException;
import com.veterinaria.demo.domain.Medicina;
import com.veterinaria.demo.service.MedicinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/medicinas")
public class MedicinaController {

    @Autowired
    private MedicinaService medicinaService;

    // Listar todas las medicinas
    @GetMapping
    public String listarMedicinas(Model model) {
        List<Medicina> medicinas = medicinaService.obtenerTodasLasMedicinas();
        model.addAttribute("medicinas", medicinas);
        return "medicinas/medicinas"; // Nombre del template para la lista
    }

    // Mostrar el formulario para agregar una nueva medicina
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaMedicina(Model model) {
        model.addAttribute("medicina", new Medicina()); // Pasamos un objeto vacío para el formulario
        return "medicinas/nuevaMedicina"; // Template para crear una nueva medicina
    }

    // Crear una nueva medicina con manejo de errores
    @PostMapping("/crear")
    public String crearMedicina(@ModelAttribute Medicina medicina, Model model) {
        try {
            // Convertir 'requierePrescripcion' a minúsculas antes de guardarlo
            medicina.setRequierePrescripcion(medicina.getRequierePrescripcion().toLowerCase());

            medicinaService.crearMedicina(medicina);
            return "redirect:/medicinas"; // Redirigir a la lista de medicinas después de crear
        } catch (MongoWriteException e) {
            model.addAttribute("error", "Error al crear la medicina: " + e.getMessage());
            model.addAttribute("medicina", medicina); // Mantener los datos del formulario
            return "medicinas/nuevaMedicina"; // Volver al formulario con el mensaje de error
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error inesperado: " + e.getMessage());
            model.addAttribute("medicina", medicina);
            return "medicinas/nuevaMedicina";
        }
    }

    // Mostrar el formulario para editar una medicina
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Optional<Medicina> medicina = medicinaService.obtenerMedicinaPorId(id);
        if (medicina.isPresent()) {
            model.addAttribute("medicina", medicina.get());
            return "medicinas/editarMedicina"; // Template con el formulario de edición
        } else {
            return "redirect:/medicinas"; // Redirigir a la lista de medicinas si no se encuentra la medicina
        }
    }

    // Editar una medicina con manejo de errores
    @PostMapping("/editar/{id}")
    public String editarMedicina(@PathVariable String id, @ModelAttribute Medicina medicina, Model model) {
        try {
            // Convertir 'requierePrescripcion' a minúsculas antes de actualizar
            medicina.setRequierePrescripcion(medicina.getRequierePrescripcion().toLowerCase());

            medicinaService.actualizarMedicina(id, medicina);
            return "redirect:/medicinas"; // Redirigir a la lista de medicinas después de editar
        } catch (MongoWriteException e) {
            model.addAttribute("error", "Error al actualizar la medicina: " + e.getMessage());
            model.addAttribute("medicina", medicina); // Mantener los datos del formulario
            return "medicinas/editarMedicina"; // Volver al formulario con el mensaje de error
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error inesperado: " + e.getMessage());
            model.addAttribute("medicina", medicina);
            return "medicinas/editarMedicina";
        }
    }

    // Eliminar una medicina
    @PostMapping("/eliminar/{id}")
    public String eliminarMedicina(@PathVariable String id) {
        medicinaService.eliminarMedicina(id);
        return "redirect:/medicinas"; // Redirigir a la lista de medicinas después de eliminar
    }
}
