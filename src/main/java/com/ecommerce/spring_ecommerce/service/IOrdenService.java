package com.ecommerce.spring_ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.spring_ecommerce.model.orden;
import com.ecommerce.spring_ecommerce.model.usuario;

public interface IOrdenService {
    List<orden> findAll();

    Optional<orden> findById(Integer id);

    orden save (orden orden);

    String generarNumeroOrden();

    List<orden> findByUsuario(usuario usuario);
}
