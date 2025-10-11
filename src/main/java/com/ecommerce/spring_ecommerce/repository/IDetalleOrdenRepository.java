package com.ecommerce.spring_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.spring_ecommerce.model.detalleOrden;

@Repository
public interface IDetalleOrdenRepository extends JpaRepository<detalleOrden, Integer> {

}
