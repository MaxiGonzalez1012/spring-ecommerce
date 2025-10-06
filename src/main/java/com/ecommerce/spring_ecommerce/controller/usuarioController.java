package com.ecommerce.spring_ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.spring_ecommerce.model.usuario;
import com.ecommerce.spring_ecommerce.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class usuarioController {

    private final Logger logger = LoggerFactory.getLogger(usuarioController.class);

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/registro")
    public String create() {
        return "usuario/registro";
    }

    @PostMapping("/save")
    public String save(usuario usuario) {
        logger.info("Usuario registro: {}", usuario);
        usuario.setTipo("USER");
        usuarioService.save(usuario);

        return "redirect:/";
    }

}
