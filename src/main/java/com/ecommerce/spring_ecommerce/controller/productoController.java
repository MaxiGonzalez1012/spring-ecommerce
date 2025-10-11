package com.ecommerce.spring_ecommerce.controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.spring_ecommerce.model.producto;
import com.ecommerce.spring_ecommerce.model.usuario;
import com.ecommerce.spring_ecommerce.service.IUsuarioService;
import com.ecommerce.spring_ecommerce.service.ProductoService;
import com.ecommerce.spring_ecommerce.service.uploadFileService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/productos")
public class productoController {

    private final Logger LOGGER = LoggerFactory.getLogger(productoController.class);

    @Autowired
    private ProductoService productoService;

    @Autowired
    private uploadFileService upload;

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }

    @GetMapping("/create")
    public String create() {
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(producto producto, @RequestParam("img") MultipartFile file, HttpSession session)
            throws IOException {
        LOGGER.info("Este es el objeto producto {}", producto);

        usuario u = usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();
        producto.setUsuario(u);

        // Image
        if (producto.getId() == null) { // Cuando se crea un producto
            String nombreImagen = upload.saveImage(file);
            producto.setImagen(nombreImagen);
        }

        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        producto producto = new producto();
        Optional<producto> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();
        LOGGER.info("Producto buscado: {}", producto);
        model.addAttribute("producto", producto);

        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        producto p = new producto();
        p = productoService.get(producto.getId()).get();

        if (file.isEmpty()) { // cuando se edita el producto pero no se cambia la imagen

            producto.setImagen(p.getImagen());
        } else {
            if (!p.getImagen().equals("default.jpg")) { // Eliminar cuando no sea la imagen por defecto
                upload.deleteImage(p.getImagen());
            }

            String nombreImagen = upload.saveImage(file);
            producto.setImagen(nombreImagen);
        }
        producto.setUsuario(p.getUsuario());
        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        producto p = new producto();
        p = productoService.get(id).get();

        if (!p.getImagen().equals("default.jpg")) { // Eliminar cuando no sea la imagen por defecto
            upload.deleteImage(p.getImagen());
        }

        productoService.delete(id);
        return "redirect:/productos";
    }

}
