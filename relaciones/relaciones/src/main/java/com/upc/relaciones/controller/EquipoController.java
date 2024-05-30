package com.upc.relaciones.controller;

import com.upc.relaciones.dto.EquipoDto;
import com.upc.relaciones.models.Equipo;
import com.upc.relaciones.service.EquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {
    final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public ResponseEntity<List<EquipoDto>> GetAll() {
        return new ResponseEntity<List<EquipoDto>>(equipoService.GetAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<EquipoDto> GetById (@PathVariable("id") Integer id)  {
        EquipoDto equipoDto = equipoService.GetById(id);
        if(equipoDto == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(equipoDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Equipo> Add (@RequestBody EquipoDto equipoDto) {
        return new ResponseEntity<>(equipoService.Add(equipoDto), HttpStatus.CREATED);
    }
}
