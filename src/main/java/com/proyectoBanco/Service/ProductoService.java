package com.proyectoBanco.Service;


import com.proyectoBanco.modelBeans.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    // create instance of our Repository
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos()
    {
        List<Producto> productos = new ArrayList<Producto>();
        productoRepository.findAll().forEach(student -> productos.add(student));
        return productos;
    }

        public Producto getProductoById(int id)
    {
        return productoRepository.findById(id).get();
    }

    public void saveOrUpdate(Producto producto)
    {
        productoRepository.save(producto);
    }

    public void delete(int id)
    {
        productoRepository.deleteById(id);
    }


}
