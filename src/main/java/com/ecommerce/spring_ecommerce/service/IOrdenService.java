package com.ecommerce.spring_ecommerce.service;

import java.util.List;

import com.ecommerce.spring_ecommerce.model.orden;

public interface IOrdenService {
    List<orden> findAll();

    orden save (orden orden);
}
