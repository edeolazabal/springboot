package com.upc.catbd2api.service;

import com.upc.catbd2api.model.Categoria;
import com.upc.catbd2api.model.CategoriaProductoDTO;
import com.upc.catbd2api.repository.CategoriaRepository;
import jakarta.persistence.Tuple;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    public CategoriaService (CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    // Obtener todos las categorias
    public List<Categoria> obtieneCategorias() { return categoriaRepository.findAll(); }

    // Obtener una categoria por Id
    public Categoria obtieneUnaCategoria(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("No existe registro con ID =" + id));
    }
    // Insertar una categoria
    public Categoria insertaCategoria (Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Modificar Categoria

    // Eliminar categoria

    // Consulta a 2 tablas para ver el total de Productos
    public List<CategoriaProductoDTO> listaTotalProductosPorCategoria() {
        List<Tuple> lista = categoriaRepository.listaTotalProductosPorCategoria();
        List<CategoriaProductoDTO> listaDTO = new ArrayList<>();
        CategoriaProductoDTO elem;
        for (Tuple t: lista) {
            elem = new CategoriaProductoDTO();
            elem.setId(t.get("id", Long.class));
            elem.setDescripcion(t.get("descripcion", String.class));
            elem.setTotal(t.get("total", Long.class));
            listaDTO.add(elem);
            elem = null;
        }
        return listaDTO;

/*
        return  categoriaRepository.listaTotalProductosPorCategoria()
                .stream()
                .map(tuple -> new CategoriaProductoDTO(
                        tuple.get("id", Long.class),
                        tuple.get("descripcion", String.class),
                        tuple.get("total", Long.class)))
                .toList();
*/
    }

}
