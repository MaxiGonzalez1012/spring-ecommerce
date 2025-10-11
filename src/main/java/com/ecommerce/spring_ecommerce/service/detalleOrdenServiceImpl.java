package com.ecommerce.spring_ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.spring_ecommerce.model.detalleOrden;
import com.ecommerce.spring_ecommerce.repository.IDetalleOrdenRepository;

@Service
public class detalleOrdenServiceImpl implements IDetalleOrdenService {

    @Autowired
    private IDetalleOrdenRepository detalleOrdenRepository;

    @Override
    public detalleOrden save(detalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

}
