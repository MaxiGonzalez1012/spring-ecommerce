package com.ecommerce.spring_ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.spring_ecommerce.model.usuario;

public interface IUsuarioService {
    Optional<usuario> findById(Integer id);

    usuario save(usuario usuario);

    Optional<usuario> findByEmail(String email);

    List<usuario> findAll();
}
