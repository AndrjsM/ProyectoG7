
package com.veterinaria.demo.controller;

import com.veterinaria.demo.domain.Proveedor;
import com.veterinaria.demo.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProveedorController {
    @Autowired
    private ProveedorService service;

    @GetMapping("/proveedores")
    public String getAll(Model model) {
        List<Proveedor> proveedores = service.findAll();
        model.addAttribute("proveedores", proveedores);
        return "proveedores/proveedores";
    }
}