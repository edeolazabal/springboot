package com.upc.catbd2api.service;

import com.upc.catbd2api.model.Producto;
import com.upc.catbd2api.repository.ProductoRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    // Obtener todos los producto
    public List<Producto> lista() { return productoRepository.findAll();}

    // Obtener producto por id
    public Producto listaPorId (Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("No existe registro con ID =" + id));
    }
    // Insertar un producto
    public Producto inserta (Producto producto) { return  productoRepository.save(producto); }
}
