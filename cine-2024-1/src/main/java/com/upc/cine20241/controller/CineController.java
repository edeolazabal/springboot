package com.upc.cine20241.controller;

import com.upc.cine20241.model.Compras;
import com.upc.cine20241.model.DatosIGV;
import com.upc.cine20241.model.Pedido;
import com.upc.cine20241.model.Tarifas;
import com.upc.cine20241.service.CineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cine")
public class CineController {
    private CineService cineService = new CineService();

    // Variables internas
    Tarifas[] tarifas = new Tarifas[] {
            new Tarifas(1,"General", 20.0),
            new Tarifas(2,"Adulto Mayor", 17.0),
            new Tarifas(3,"Martes", 15.0),
            new Tarifas(4,"Socio", 13.5)
    };

    @PostMapping
    public ResponseEntity<Compras> entradas (@RequestBody Pedido pedido){
        Compras compra = new Compras();  // incializado el objeto compra
        // Asignar valores a los atributos de la compra
        compra.setQuantity(pedido.getQuantity());
        compra.setCategory(tarifas[pedido.getId()-1].getCategory());
        compra.setAmount(pedido.getQuantity() * tarifas[pedido.getId()-1].getPrice());

        return new ResponseEntity<>(compra, HttpStatus.CREATED);

    }

    @PostMapping("/igv")
    public ResponseEntity<Compras> entradasConIGV (@RequestBody Pedido pedido){
        Compras compra = new Compras();  // incializado el objeto compra
        // Asignar valores a los atributos de la compra
        compra.setQuantity(pedido.getQuantity());
        compra.setCategory(tarifas[pedido.getId()-1].getCategory());
        compra.setAmount(pedido.getQuantity() * tarifas[pedido.getId()-1].getPrice());

        //
        DatosIGV datosIGV = cineService.calculaImportes(tarifas[pedido.getId()-1].getPrice(), pedido.getQuantity() );
        compra.setMontoIGV(datosIGV.getMontoIGV());
        compra.setImporteConIGV(datosIGV.getTotalConGV());

        return new ResponseEntity<>(compra, HttpStatus.CREATED);

    }
    @GetMapping("/demo/{d1}")
    public ResponseEntity<String> demo (@PathVariable String d1) {
        return new ResponseEntity<> ("Hola " + d1, HttpStatus.OK);
    }
}
