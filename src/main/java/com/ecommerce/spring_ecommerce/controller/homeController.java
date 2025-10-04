package com.ecommerce.spring_ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.spring_ecommerce.model.detalleOrden;
import com.ecommerce.spring_ecommerce.model.orden;
import com.ecommerce.spring_ecommerce.model.producto;
import com.ecommerce.spring_ecommerce.service.ProductoService;

@Controller
@RequestMapping("/")
public class homeController {

    private final Logger log = LoggerFactory.getLogger(homeController.class);

    @Autowired
    private ProductoService productoService;

    List<detalleOrden> detalles = new ArrayList<detalleOrden>();

    orden orden = new orden();

    @GetMapping("")
    public String home(Model model) {

        model.addAttribute("productos", productoService.findAll());

        return "usuario/home";
    }

	@GetMapping("productohome/{id}")
	public String productoHome(@PathVariable Integer id, Model model) {
		log.info("Id producto enviado como parámetro {}", id);
        producto producto = new producto();
        Optional<producto> productoOptional = productoService.get(id);
        producto = productoOptional.get();

        model.addAttribute("producto", producto);

		return "usuario/productohome";
	}

    @PostMapping("/cart")
    public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad, Model model) {
        detalleOrden detalleOrden = new detalleOrden();
        producto producto = new producto();
        double sumaTotal = 0;

        Optional<producto> optionalProducto = productoService.get(id);
        log.info("Producto añadido: {}", optionalProducto.get());
        log.info("Cantidad: {}", cantidad);
        producto = optionalProducto.get();

        detalleOrden.setCantidad(cantidad);
        detalleOrden.setPrecio(producto.getPrecio());
        detalleOrden.setNombre(producto.getNombre());
        detalleOrden.setTotal(producto.getPrecio()*cantidad);
        detalleOrden.setProducto(producto);

        detalles.add(detalleOrden);

        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "usuario/carrito";
    }

    @GetMapping("/delete/cart/{id}")
    public String deleteProductoCart(@PathVariable Integer id, Model model) {
        List<detalleOrden> ordenesNueva = new ArrayList<detalleOrden>();

        for (detalleOrden detalleOrden : detalles) {
            if (detalleOrden.getProducto().getId() != id) {
                ordenesNueva.add(detalleOrden);
            }
        }

        detalles = ordenesNueva;

        double sumaTotal = 0;
        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);
        
        return "usuario/carrito";
    }
}
