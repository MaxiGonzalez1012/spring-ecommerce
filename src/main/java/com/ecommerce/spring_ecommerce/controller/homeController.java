package com.ecommerce.spring_ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.spring_ecommerce.service.ProductoService;

@Controller
@RequestMapping("/")
public class homeController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String home(Model model) {

        model.addAttribute("productos", productoService.findAll());

        return "usuario/home";
    }

}
