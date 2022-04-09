package com.proyectoBanco.Service;

import com.proyectoBanco.DTO.ProductoDTO;
import com.proyectoBanco.modelBeans.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MappingService {
    @Autowired
    // create instance of our UserRepository
    private ProductoRepository productoRepository;

    //create getAllUsersLocation() method that returns a list of productos

    public List<ProductoDTO> getAllProductos() {
        return ((List<Producto>) productoRepository
                .findAll())
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());
    }
    // create convertDataIntoDTO() method that returns productoData

    private ProductoDTO convertDataIntoDTO (Producto productoData) {

        // create instance of our UserLocationDTO class
        ProductoDTO dto = new ProductoDTO();

        //set username and userId in dto from the userData
        dto.setId(productoData.getId());
        dto.setNombre(productoData.getNombre());
        dto.setDescripcion(productoData.getDescripcion());
        dto.setPrecio(productoData.getPrecio());

        return dto;
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
