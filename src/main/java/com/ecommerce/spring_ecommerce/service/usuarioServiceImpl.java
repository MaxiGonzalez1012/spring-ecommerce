package com.ecommerce.spring_ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.spring_ecommerce.model.usuario;
import com.ecommerce.spring_ecommerce.repository.IUsuarioRepository;

@Service
public class usuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public Optional<usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public usuario save(usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public List<usuario> findAll() {
        return usuarioRepository.findAll();
    }
}
