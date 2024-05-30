package com.upc.tarifasapi.controller;

import com.upc.tarifasapi.dto.Listado;
import com.upc.tarifasapi.dto.ListadoDescuento;
import com.upc.tarifasapi.dto.ListadoIgv;
import com.upc.tarifasapi.dto.SoloCategoriaDTO;
import com.upc.tarifasapi.service.ListadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class ListadoController {
    @Autowired
    private final ListadoService listadoService;

    public ListadoController(ListadoService listadoService) {
        this.listadoService = listadoService;
    }

    @GetMapping("/listado")
    public ResponseEntity<List<Listado>> lista() { return new ResponseEntity<>(listadoService.lista(), HttpStatus.OK); }

    @GetMapping("/listadoIgv")
    public ResponseEntity<List<ListadoIgv>> listaIgv() { return new ResponseEntity<>(listadoService.listaIgv(), HttpStatus.OK); }

    @GetMapping("/listadoDescuento")
    public ResponseEntity<List<ListadoDescuento>> listaDescuento() { return new ResponseEntity<>(listadoService.listaDescuento(), HttpStatus.OK); }

    @GetMapping("/soloCategoria")
    public ResponseEntity<List<SoloCategoriaDTO>> listaSoloCategoria() { return new ResponseEntity<>(listadoService.listaSoloCategoria(), HttpStatus.OK); }

    @GetMapping()
    public ResponseEntity<?> ejemplo() {
        Integer x = 123; //listadoService.ejemplo();
      //  return new ResponseEntity<>(x, HttpStatus.OK);
        Map<String, Integer> salida = new HashMap<>();
        salida.put("EjemploSalida", x);
        return new ResponseEntity<>(salida, HttpStatus.OK);
    }
}
