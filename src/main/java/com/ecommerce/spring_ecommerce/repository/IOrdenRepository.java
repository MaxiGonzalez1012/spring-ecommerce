package com.ecommerce.spring_ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.spring_ecommerce.model.orden;
import com.ecommerce.spring_ecommerce.model.usuario;

@Repository
public interface IOrdenRepository extends JpaRepository<orden, Integer>{
    List<orden> findByUsuario(usuario usuario);
}
