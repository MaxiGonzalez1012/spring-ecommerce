package com.ecommerce.spring_ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.spring_ecommerce.model.orden;
import com.ecommerce.spring_ecommerce.repository.IOrdenRepository;

@Service
public class ordenServiceImpl implements IOrdenService{

    @Autowired
    private IOrdenRepository ordenRepository;

    @Override
    public orden save(orden orden) {
        return ordenRepository.save(orden);
    }
}
