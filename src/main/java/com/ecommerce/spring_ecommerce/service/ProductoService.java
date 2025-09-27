package com.ecommerce.spring_ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.spring_ecommerce.model.producto;

public interface ProductoService {
    public producto save(producto producto);

    public Optional<producto> get(Integer id);

    public void update(producto producto);

    public void delete(Integer id);

    public List<producto> findAll();

}
