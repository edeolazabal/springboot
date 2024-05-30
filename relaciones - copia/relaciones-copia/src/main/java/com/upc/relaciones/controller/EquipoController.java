package com.upc.relaciones.controller;

import com.upc.relaciones.dto.EquipoDto;
import com.upc.relaciones.dto.EstudianteDto;
import com.upc.relaciones.models.Equipo;
import com.upc.relaciones.models.Estudiante;
import com.upc.relaciones.services.EquipoService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
        return new ResponseEntity<>(equipoService.GetById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Equipo> Add (@RequestBody EquipoDto equipoDto) {
        return new ResponseEntity<>(equipoService.Add(equipoDto), HttpStatus.CREATED);
    }
}
