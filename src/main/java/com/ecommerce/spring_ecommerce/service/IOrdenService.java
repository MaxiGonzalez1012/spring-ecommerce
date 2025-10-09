package com.ecommerce.spring_ecommerce.service;

import java.util.List;

import com.ecommerce.spring_ecommerce.model.orden;
import com.ecommerce.spring_ecommerce.model.usuario;

public interface IOrdenService {
    List<orden> findAll();

    orden save (orden orden);

    String generarNumeroOrden();

    List<orden> findByUsuario(usuario usuario);
}
