package com.veterinaria.demo.controller;

import com.veterinaria.demo.domain.Producto;
import com.veterinaria.demo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Listar todos los Productos
    @GetMapping
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        model.addAttribute("productos", productos);
        return "productos/productos"; // Nombre del template para la lista
    }

    // Mostrar el formulario para agregar un nuevo producto
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoProducto(Model model) {
        model.addAttribute("producto", new Producto()); // Pasamos un objeto vacío para el formulario
        return "productos/nuevoProducto"; // Template para crear un nuevo Producto
    }

    // Crear un nuevo Producto
    @PostMapping("/crear")
    public String crearProducto(@ModelAttribute Producto producto) {
        productoService.crearProducto(producto);
        return "redirect:/productos"; // Redirigir a la lista de Productos después de crear
    }

    // Mostrar el formulario para editar un Producto
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Optional<Producto> producto = productoService.obtenerProductoPorId(id);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            return "productos/editarProducto"; // Template con el formulario de edición
        } else {
            return "redirect:/productos"; // Redirigir a la lista de productos si no se encuentra el producto
        }
    }

    // Editar un producto
    @PostMapping("/editar/{id}")
    public String editarProducto(@PathVariable String id, @ModelAttribute Producto producto) {
        productoService.actualizarProducto(id, producto);
        return "redirect:/productos"; // Redirigir a la lista de Productos después de editar
    }

    // Eliminar una medicina
    @PostMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable String id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos"; // Redirigir a la lista de Productos después de eliminar
    }
}