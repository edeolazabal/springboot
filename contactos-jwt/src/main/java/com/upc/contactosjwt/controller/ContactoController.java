package com.upc.contactosjwt.controller;

import com.upc.contactosjwt.model.Contacto;
import com.upc.contactosjwt.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactos")
public class ContactoController {

    @Autowired
    ContactoService contactoService;

    @GetMapping
    public ResponseEntity<List<Contacto>> listar() { return new ResponseEntity<List<Contacto>>(contactoService.listar(), HttpStatus.OK); }

    @PostMapping
    public ResponseEntity<Contacto> crear(@RequestBody Contacto contacto) { return new ResponseEntity<Contacto>(contactoService.crear(contacto), HttpStatus.CREATED);}

}
