package com.veterinaria.demo.controller;

import com.veterinaria.demo.domain.Producto;
import com.veterinaria.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService service;

    @GetMapping("/productos")
    public String getAll(Model model) {
        List<Producto> productos = service.findAll();
        model.addAttribute("productos", productos);
        return "productos/productos";
    }
}