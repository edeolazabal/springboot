package com.upc.relaciones.controller;

import com.upc.relaciones.dto.EstudianteCursoDto;
import com.upc.relaciones.dto.EstudianteDto;
import com.upc.relaciones.dto.JugadorDto;
import com.upc.relaciones.models.Estudiante;
import com.upc.relaciones.models.Jugador;
import com.upc.relaciones.services.EquipoService;
import com.upc.relaciones.services.JugadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/jugador")
public class JugadorController {
    final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }
    @GetMapping
    public ResponseEntity<List<JugadorDto>> GetAll () {
        return new ResponseEntity<>(jugadorService.GetAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<JugadorDto> GetById (@PathVariable("id") Integer id) {
        JugadorDto jugadorDto = jugadorService.GetById(id);
        if(jugadorDto == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(jugadorDto, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Jugador> Add (@RequestBody JugadorDto jugadorDto) {
        Jugador jugador = jugadorService.Add(jugadorDto);
        if(jugador == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(jugador, HttpStatus.CREATED);
    }

}
