package com.ecommerce.spring_ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.spring_ecommerce.model.orden;
import com.ecommerce.spring_ecommerce.repository.IOrdenRepository;

@Service
public class ordenServiceImpl implements IOrdenService {

    @Autowired
    private IOrdenRepository ordenRepository;

    @Override
    public orden save(orden orden) {
        return ordenRepository.save(orden);
    }

    @Override
    public List<orden> findAll() {
        return ordenRepository.findAll();
    }

    public String generarNumeroOrden(int num) {

        String numeroOrden = String.valueOf(num);
        int numDigitos = numeroOrden.length(); // numero de digitos

        for (int j = numDigitos; j <= 9; j++)// añadimos los ceros
            numeroOrden = "0" + numeroOrden;

        return numeroOrden;
    }
}
