package com.upc.pruebabrenda.controller;

import com.upc.pruebabrenda.model.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prueba")
public class PruebaController {
    @PostMapping
    public ResponseEntity<Pedido> prueba (@RequestBody Pedido pedido) {
        Pedido nuevoPedido = new Pedido();
        nuevoPedido.setId(pedido.getId());
        nuevoPedido.setCantidad(pedido.getCantidad());
        return new ResponseEntity<>(nuevoPedido, HttpStatus.OK);
    }
}
