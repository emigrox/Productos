package com.proyectoBanco.controller;

import com.proyectoBanco.DTO.ProductoDTO;
import com.proyectoBanco.Service.MappingService;
import com.proyectoBanco.modelBeans.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MappingController {
    // create instance of the mapService class
    @Autowired
    private MappingService mapService;
    // create endpoint
    @GetMapping("/productos")
    // when user hit the endpoint, it returns the response body
    @ResponseBody
    public List<ProductoDTO> getAllProductos() {
        // call getProductos() method from the service which we created before
        // store the result in a list of productoDTO
        List <ProductoDTO> productos = mapService.getAllProductos();
        // return productos
        return productos;
    }

    @GetMapping("/producto/{id}")
    private Producto getProducto(@PathVariable("id") int id)
    {
        return mapService.getProductoById(id);
    }

    @DeleteMapping("/producto/{id}")
    private void deleteProducto(@PathVariable("id") int id)
    {
        mapService.delete(id);
    }
    //creating post mapping that post the student detail in the database

    @PostMapping("/producto")
    private int saveProducto(@RequestBody Producto producto)
    {
        mapService.saveOrUpdate(producto);
        return producto.getId();
    }

}