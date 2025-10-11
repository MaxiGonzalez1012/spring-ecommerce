package com.ecommerce.spring_ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.spring_ecommerce.model.usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<usuario, Integer> {
    Optional<usuario> findByEmail(String email);
}
