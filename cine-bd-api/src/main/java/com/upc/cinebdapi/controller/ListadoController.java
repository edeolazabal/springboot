package com.upc.cinebdapi.controller;

import com.upc.cinebdapi.model.Listado;
import com.upc.cinebdapi.service.ListadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/listado")
public class ListadoController {
    @Autowired
    private final ListadoService listadoService;

    public ListadoController(ListadoService listadoService) {
        this.listadoService = listadoService;
    }


    @GetMapping
    public ResponseEntity<List<Listado>> lista() {
        return new ResponseEntity<>(listadoService.lista(), HttpStatus.OK);

    }

}
