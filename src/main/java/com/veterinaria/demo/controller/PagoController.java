package com.veterinaria.demo.controller;

import com.veterinaria.demo.domain.Pago;
import com.veterinaria.demo.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PagoController {
    @Autowired
    private PagoService service;

    @GetMapping("/pagos")
    public String getAll(Model model) {
        List<Pago> pagos = service.findAll();
        model.addAttribute("pagos", pagos);
        return "pagos/pagos";
    }
}