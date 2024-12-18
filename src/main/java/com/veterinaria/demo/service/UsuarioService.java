package com.veterinaria.demo.service;
import com.veterinaria.demo.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findById(String id);
    Usuario save(Usuario usuario);
    void deleteById(String id);
}