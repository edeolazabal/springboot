package com.upc.entradascineapi.controller;

import com.upc.entradascineapi.model.Compra;
import com.upc.entradascineapi.model.Pedido;
import com.upc.entradascineapi.model.Tarifa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EntradasController {
    Tarifa[] tarifas = new Tarifa[] {new Tarifa(1, "General", 20.0),
            new Tarifa(2, "Adulto Mayor", 17.0),
            new Tarifa(3, "Martes", 15.0),
            new Tarifa(4, "Socio", 13.5),
    };

    @PostMapping
    public ResponseEntity<Compra> entradas (@RequestBody Pedido pedido) {
        Compra compra = new Compra();
        compra.setCantidad(pedido.getCantidad());
        compra.setCategoria(tarifas[pedido.getId_categoria()-1].getCategoria());
        compra.setImporte(pedido.getCantidad() * tarifas[pedido.getId_categoria()-1].getPrecio());
        return new ResponseEntity<>(compra, HttpStatus.CREATED);
    }

}
