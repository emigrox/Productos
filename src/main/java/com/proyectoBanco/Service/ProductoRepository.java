package com.proyectoBanco.Service;
import com.proyectoBanco.modelBeans.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface ProductoRepository extends CrudRepository<Producto, Integer> {}


