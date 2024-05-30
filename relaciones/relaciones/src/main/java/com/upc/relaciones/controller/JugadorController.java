package com.upc.relaciones.controller;

import com.upc.relaciones.dto.CuentaJugadorDto;
import com.upc.relaciones.dto.JugadorDto;
import com.upc.relaciones.models.Jugador;
import com.upc.relaciones.service.JugadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public ResponseEntity<JugadorDto> Add (@RequestBody JugadorDto jugadorDto) {
        Jugador jugador = jugadorService.Add(jugadorDto);
        if(jugador == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        jugadorDto.setId(jugador.getId());
        return new ResponseEntity<>(jugadorDto, HttpStatus.CREATED);
    }

    @GetMapping("/cuentaJugadores")
    public ResponseEntity<Jugador> cuentaJugadores (@PathVariable Integer id) {
        return new ResponseEntity<>(jugadorService.cuentaJugador(id), HttpStatus.OK);
    }
    @GetMapping("/cuentaJugadores2")
    public ResponseEntity<CuentaJugadorDto> cuentaJugadores2 (@PathVariable Integer id) {
        return new ResponseEntity<>(jugadorService.cuentaJugador2(id), HttpStatus.OK);
    }

    @GetMapping("/obtieneNombre")
    public ResponseEntity<String> obtieneNombre (@PathVariable Integer id) {
        return new ResponseEntity<>(jugadorService.obtieneNombre(id), HttpStatus.OK);
    }


}
