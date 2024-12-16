package com.veterinaria.demo.controller;

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

    // Crear una nueva medicina
    @PostMapping("/crear")
    public String crearMedicina(@ModelAttribute Medicina medicina) {
        medicinaService.crearMedicina(medicina);
        return "redirect:/medicinas"; // Redirigir a la lista de medicinas después de crear
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

    // Editar una medicina
    @PostMapping("/editar/{id}")
    public String editarMedicina(@PathVariable String id, @ModelAttribute Medicina medicina) {
        medicinaService.actualizarMedicina(id, medicina);
        return "redirect:/medicinas"; // Redirigir a la lista de medicinas después de editar
    }

    // Eliminar una medicina
    @PostMapping("/eliminar/{id}")
    public String eliminarMedicina(@PathVariable String id) {
        medicinaService.eliminarMedicina(id);
        return "redirect:/medicinas"; // Redirigir a la lista de medicinas después de eliminar
    }
}
