package com.upc.relaciones.controller;

import com.upc.relaciones.dto.PersonaDto;
import com.upc.relaciones.models.Persona;
import com.upc.relaciones.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
    @GetMapping
    public ResponseEntity<List<PersonaDto>> GetAll () {
        return new ResponseEntity<>(personaService.GetAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PersonaDto> GetById (@PathVariable("id") Integer id) {
        PersonaDto personaDto = personaService.GetById(id);
        if(personaDto == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(personaDto, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Persona> Add (@RequestBody PersonaDto personaDto) {
        return new ResponseEntity<>(personaService.Add(personaDto), HttpStatus.CREATED);
    }
}
