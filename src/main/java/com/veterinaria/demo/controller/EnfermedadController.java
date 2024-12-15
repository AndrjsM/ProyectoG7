package com.veterinaria.demo.controller;

import com.veterinaria.demo.domain.Enfermedad;
import com.veterinaria.demo.service.EnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EnfermedadController {
    @Autowired
    private EnfermedadService service;

    @GetMapping("/enfermedades")
    public String getAll(Model model) {
        List<Enfermedad> enfermedades = service.findAll();
        model.addAttribute("enfermedades", enfermedades);
        return "enfermedades/enfermedades";
    }
}
