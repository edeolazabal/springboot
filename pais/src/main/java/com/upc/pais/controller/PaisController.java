package com.upc.pais.controller;

import com.upc.pais.entity.Pais;
import com.upc.pais.repository.PaisRepository;
import com.upc.pais.service.PaisService;
import jakarta.websocket.server.PathParam;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class PaisController {

    PaisService paisService = null;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }
    @GetMapping()
    public ResponseEntity<List<Pais>> list () { return new ResponseEntity<>(paisService.list(), HttpStatus.OK);}

    @GetMapping("{id}")
    public ResponseEntity<Pais> listById (@PathVariable Long id) { return new ResponseEntity<>(paisService.listById(id), HttpStatus.OK);}

    @PostMapping()
    public ResponseEntity<Pais> insert (@RequestBody Pais pais) { return new ResponseEntity<>(paisService.insert(pais), HttpStatus.CREATED);}

    @PutMapping("{id}")
    public ResponseEntity<Pais> update (@PathVariable Long id, @RequestBody Pais pais) { return new ResponseEntity<>(paisService.update(id, pais), HttpStatus.OK);}

    @DeleteMapping("{id}")
    public ResponseEntity<Pais> delete (@PathVariable Long id) { return new ResponseEntity<>(paisService.delete(id), HttpStatus.OK);}

}
