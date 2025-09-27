package com.ecommerce.spring_ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.spring_ecommerce.model.producto;
import com.ecommerce.spring_ecommerce.repository.ProductoRepository;

@Service
public class productoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public producto save(producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<producto> get(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public void update(producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }

}
