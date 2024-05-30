package com.upc.test.controller;

import com.upc.test.model.Curso;
import com.upc.test.model.CursoDto;
import com.upc.test.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/cursos")
public class CursoController {
    final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    @GetMapping
    public ResponseEntity<List<Curso>> listar () {
        return new ResponseEntity<>(cursoService.listar(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Curso> crear (@RequestBody CursoDto cursoDto) {
        return new ResponseEntity<>(cursoService.crear(cursoDto), HttpStatus.CREATED);
    }
}
