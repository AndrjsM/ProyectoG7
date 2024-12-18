package com.veterinaria.demo.service.impl;

import com.veterinaria.demo.dao.UsuarioDao;
import com.veterinaria.demo.domain.Usuario;
import com.veterinaria.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario findById(String id) {
        Optional<Usuario> usuario = usuarioDao.findById(id);
        return usuario.orElse(null);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public void deleteById(String id) {
        usuarioDao.deleteById(id);
    }
}