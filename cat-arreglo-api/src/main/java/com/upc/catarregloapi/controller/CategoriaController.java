package com.upc.catarregloapi.controller;

import com.upc.catarregloapi.model.Categoria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;

@RestController
@RequestMapping
public class CategoriaController {

    private final ArrayList<Categoria> categorias = new ArrayList<>();

    @GetMapping("/")
    public ResponseEntity<ArrayList<Categoria>> consulta() {
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @PostMapping("/categoria")
    public ResponseEntity<Categoria> inserta (@RequestBody Categoria cat) {
        categorias.add(cat);
        return  new ResponseEntity<>(cat, HttpStatus.CREATED);
    }

    @PutMapping("/categoria/{id}")
    public ResponseEntity<Categoria> modifica (@PathVariable Integer id, @RequestBody Categoria cat) {
        Integer i = 0;
        for (Categoria categoria: categorias) {
            if (categoria.getId() == id) {
                categorias.set(i, cat);
                return  new ResponseEntity<>(cat, HttpStatus.OK);
            }
            i++;
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        //throw  new HttpClientErrorException(HttpStatus.NOT_FOUND, "Id. no esta en el arreglo");

    }

    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<Categoria> elimina(@PathVariable Integer id) {
        for (Categoria categoria: categorias) {
            if (categoria.getId() == id) {
                categorias.remove(categoria);
                return new ResponseEntity<>(categoria, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


}
