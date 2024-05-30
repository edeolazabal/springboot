package com.upc.catbd2api.controller;

import com.upc.catbd2api.model.Categoria;
import com.upc.catbd2api.model.CategoriaProductoDTO;
import com.upc.catbd2api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> lista() {
        return new ResponseEntity<>(categoriaService.obtieneCategorias(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Categoria> consultaPorId (@PathVariable(value = "id") Long id  ) throws Exception {
        return  new ResponseEntity<>(categoriaService.obtieneUnaCategoria(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Categoria> inserta (@RequestBody Categoria categoria)  {
        return new ResponseEntity<>(categoriaService.insertaCategoria(categoria), HttpStatus.CREATED);
    }
    @GetMapping("/total")
    public ResponseEntity<List<CategoriaProductoDTO>> listaTotal() {
        return new ResponseEntity<>(categoriaService.listaTotalProductosPorCategoria(), HttpStatus.OK);
    }
}
