package com.upc.cinearray.controller;

import com.upc.cinearray.model.Compras;
import com.upc.cinearray.model.Pedido;
import com.upc.cinearray.model.Tarifas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping
public class CineController {

    //private ArrayList<Tarifas> tarifas = new ArrayList<>();
    // private ArrayList<Tarifas> tarifas = new ArrayList<Tarifas> ({1, "General", 20.0}, {1, "General", 20.0}, {1, "General", 20.0}{1, "General", 20.0});
    Tarifas[] tarifas = new Tarifas[] {new Tarifas(1, "General", 20.0),
            new Tarifas(2, "Adulto Mayor", 17.0),
            new Tarifas(3, "Martes", 15.0),
            new Tarifas(4, "Socio", 13.0)};

    @PostMapping
    public ResponseEntity<Compras> entradas (@RequestBody Pedido pedido) {
        Compras compra = new Compras();
        compra.setQuantity(pedido.getQuantity());
        compra.setCategory(tarifas[pedido.getId()-1].getCategory());
        compra.setAmount(pedido.getQuantity() * tarifas[pedido.getId()-1].getPrice());
        return new ResponseEntity<>(compra, HttpStatus.CREATED);
    }
}
