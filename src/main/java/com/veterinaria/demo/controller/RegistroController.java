package com.veterinaria.demo.controller;

import com.veterinaria.demo.domain.Cliente;
import com.veterinaria.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.transaction.annotation.Transactional;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private ClienteService clienteService;

    // Ruta para mostrar el formulario de registro
    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("cliente", new Cliente()); // Cliente vacío para el formulario
        return "registro/registro"; // Nombre de la plantilla de registro
    }

    // Ruta para manejar el formulario de registro
    @Transactional
    @PostMapping
    public String registerCliente(@ModelAttribute Cliente cliente, Model model) {
        try {
            // Debug: Validar Cliente recibido
            System.out.println("Recibiendo datos del Cliente: " + cliente);

            // Guardar el cliente
            Cliente savedCliente = clienteService.save(cliente);
            if (savedCliente == null || savedCliente.getCedula() == null) {
                model.addAttribute("error", "Error al guardar el cliente.");
                return "registro/registro";
            }
            System.out.println("Cliente guardado: " + savedCliente);

            // Registro completado exitosamente
            return "redirect:/"; // Redirigir a la página de inicio o una página de éxito

        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar: " + e.getMessage());
            return "registro/registro"; // Volver al formulario en caso de error
        }
    }
}