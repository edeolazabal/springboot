package com.upc.relaciones.controller;

import com.upc.relaciones.dto.DniDto;
import com.upc.relaciones.dto.JugadorDto;
import com.upc.relaciones.models.Dni;
import com.upc.relaciones.models.Jugador;
import com.upc.relaciones.services.DniService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/dni")
public class DniController {
    final DniService dniService;

    public DniController(DniService dniService) {
        this.dniService = dniService;
    }
    @GetMapping
    public ResponseEntity<List<DniDto>> GetAll () {
        return new ResponseEntity<>(dniService.GetAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DniDto> GetById (@PathVariable("id") Integer id) {
        DniDto dniDto = dniService.GetById(id);
        if(dniDto == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dniDto, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Dni> Add (@RequestBody DniDto dniDto) {
        Dni dni = dniService.Add(dniDto);
        if(dni == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dni, HttpStatus.CREATED);
    }
}
